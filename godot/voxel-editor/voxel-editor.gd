tool
extends Spatial

export(int) var RAY_LENGTH = 1000

export(float) var VOXEL_SCALE = 0.25
export(Color) var VOXEL_COLOR = Color(1, 1, 1, 1)

var CURSOR
export(bool) var CURSOR_VISIBLE = true
export(Color) var CURSOR_COLOR = Color(1, 0, 0, 0.6)

export(bool) var PLANE_VISIBLE = true setget plane_visibility
export(Color) var PLANE_COLOR = Color(1, 1, 1, 1) setget plane_color

export(bool) var LIGHT_VISIBLE = true setget light_visibility
export(Color) var LIGHT_COLOR = Color(1, 1, 1, 1) setget light_color

func _ready():
	Cursor()
	
	set_process_input(true)

func raycast(event):
	var from = $view.project_ray_origin(event.position)
	var to = from + $view.project_ray_normal(event.position) * RAY_LENGTH
	return get_world().direct_space_state.intersect_ray(from, to, [self, CURSOR])

func _input(event):
	if (event is InputEventMouseButton || event is InputEventScreenTouch) and event.pressed and event.button_index == 1:
		var hit = raycast(event)
		if (hit):
			add_voxel(hit.position + (hit.normal * (VOXEL_SCALE / 2)))
	
	if (event is InputEventMouseMotion || event is InputEventScreenDrag):
		var hit = raycast(event)
		if (hit):
			update_cursor(hit.position + (hit.normal * (VOXEL_SCALE / 2)))

func plane_visibility(value):
	if has_node("plane"):
		PLANE_VISIBLE = value
		$plane.visible = value

func plane_color(value):
	if has_node("plane"):
		PLANE_COLOR = value
		$plane.get_surface_material(0).albedo_color = value

func light_visibility(value):
	if has_node("light"):
		LIGHT_VISIBLE = value
		$light.visible = value

func light_color(value):
	if has_node("light"):
		LIGHT_COLOR = value
		$light.light_color = value

func pos_to_grid(position):
	return ((position / VOXEL_SCALE).floor() * VOXEL_SCALE) + (Vector3(VOXEL_SCALE, VOXEL_SCALE, VOXEL_SCALE) / 2)

func Cursor():
	CURSOR = MeshInstance.new()
	CURSOR.scale = Vector3(VOXEL_SCALE, VOXEL_SCALE, VOXEL_SCALE)
	CURSOR.mesh = CubeMesh.new()
	
	CURSOR.set_surface_material(0, SpatialMaterial.new())
	CURSOR.get_surface_material(0).albedo_color = CURSOR_COLOR
	
	add_child(CURSOR)

func update_cursor(position=Vector3()):
	if position.length() == 0:
		CURSOR.visible = false
	else:
		CURSOR.visible = true
		CURSOR.translation = pos_to_grid(position)

func Voxel(options={}):
	var voxel = MeshInstance.new()
	voxel.scale = Vector3(VOXEL_SCALE, VOXEL_SCALE, VOXEL_SCALE)
	voxel.mesh = CubeMesh.new()
	voxel.create_convex_collision()
	
	voxel.set_surface_material(0, SpatialMaterial.new())
	voxel.get_surface_material(0).albedo_color = options.color if options.has('color') else VOXEL_COLOR
	
	return voxel

func add_voxel(position, options={}):
	var voxel = Voxel(options)
	
	add_child(voxel)
	voxel.translation = pos_to_grid(position)

func remove_voxel(position, options={}):
	pass
