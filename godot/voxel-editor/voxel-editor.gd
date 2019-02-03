tool
extends Spatial

export(String, 'add', 'remove', 'paint', 'select') var DOING = 'add' setget update_doing
func update_doing(value):
	DOING = value


export(int) var RAY_LENGTH = 1000 setget update_ray_length
func update_ray_length(value):
	RAY_LENGTH = value


export(float) var VOXEL_SCALE = 0.25 setget update_scale
func update_scale(value):
	VOXEL_SCALE = value
	GRID_RATE = 0.25 * (VOXEL_SCALE / 0.125)
	GRID_CORRECTION = 0.25 * (VOXEL_SCALE / 0.25)

export(Color) var VOXEL_COLOR = Color(1, 1, 1, 1) setget update_voxel_color
func update_voxel_color(value):
	VOXEL_COLOR = value
	
	if has_node('controls/options/voxel/default_color'):
		$controls/options/voxel/default_color.color = value


var CURSOR
export(bool) var CURSOR_VISIBLE = true setget update_cursor_visibility
func update_cursor_visibility(value):
	CURSOR_VISIBLE = value

export(Color) var CURSOR_COLOR = Color(1, 0, 0, 0.6) setget update_cursor_color
func update_cursor_color(value):
	CURSOR_COLOR = value


export(bool) var PLANE_VISIBLE = true setget update_plane_visibility
func update_plane_visibility(value):
	PLANE_VISIBLE = value
	
	if has_node("plane"):
		$plane.visible = value

export(Color) var PLANE_COLOR = Color(1, 1, 1, 1) setget update_plane_color
func update_plane_color(value):
	PLANE_COLOR = value
	
	if has_node("plane"):
		$plane.get_surface_material(0).albedo_color = value


export(bool) var LIGHT_VISIBLE = true setget update_light_visibility
func update_light_visibility(value):
	LIGHT_VISIBLE = value
	
	if has_node("light"):
		$light.visible = value

export(Color) var LIGHT_COLOR = Color(1, 1, 1, 1) setget update_light_color
func update_light_color(value):
	LIGHT_COLOR = value
	
	if has_node("light"):
		$light.light_color = value


var GRID_RATE = 0.25 * (VOXEL_SCALE / 0.125)
var GRID_CORRECTION = 0.25 * (VOXEL_SCALE / 0.25)

#func _enter_tree():
#	print('loading...')
#	if (Engine.editor_hint):
#		print('from editor!')
#		set_process_input(true)
#	else:
#		print('from runtime!')
#
#func _exit_tree():
#	print('left!')

func _ready():
	Cursor()
	
	set_process_input(true)
	
	$controls/options/voxel_view.connect('toggled', self, 'on_voxel_view')
	
	$controls/options/voxel/default_color.connect('color_changed', self, 'update_voxel_color')
	
	$controls/options/voxel/add.connect('button_down', self, 'update_doing', ['add'])
	$controls/options/voxel/remove.connect('button_down', self, 'update_doing', ['remove'])
	$controls/options/voxel/paint.connect('button_down', self, 'update_doing', ['paint'])
	$controls/options/voxel/select.connect('button_down', self, 'update_doing', ['select'])

# GUI
func on_voxel_view(value):
	$controls/options/voxel.visible = value

# CORE
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

func pos_to_grid(position):
	return ((position / GRID_RATE).floor() * GRID_RATE) + (Vector3(GRID_CORRECTION, GRID_CORRECTION, GRID_CORRECTION))

func Cursor():
	CURSOR = MeshInstance.new()
	CURSOR.scale = Vector3(VOXEL_SCALE, VOXEL_SCALE, VOXEL_SCALE)
	CURSOR.mesh = CubeMesh.new()
	
	CURSOR.material_override = SpatialMaterial.new()
	CURSOR.material_override.flags_transparent = true
	CURSOR.material_override.albedo_color = CURSOR_COLOR
	
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
	
	voxel.material_override = SpatialMaterial.new()
	voxel.material_override.albedo_color = options.color if options.has('color') else VOXEL_COLOR
	
	return voxel

func add_voxel(position, options={}):
	var voxel = Voxel(options)
	
	add_child(voxel)
	voxel.translation = pos_to_grid(position)

func remove_voxel(position, options={}):
	pass
