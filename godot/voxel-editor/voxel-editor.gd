tool
extends Spatial

export(int) var RAY_LENGTH = 1000

export(float) var VOXEL_SCALE = 0.5
export(Color) var VOXEL_COLOR = Color(1, 1, 1, 1)

export(bool) var PLANE_VISIBLE = true setget plane_visibility
export(Color) var PLANE_COLOR = Color(1, 1, 1, 1) setget plane_color

func _ready():
	set_process_input(true)

func _input(event):
	if event is InputEventMouseButton and event.pressed and event.button_index == 1:
		var from = $view.project_ray_origin(event.position)
		var to = from + $view.project_ray_normal(event.position) * RAY_LENGTH
		var hit = get_world().direct_space_state.intersect_ray(from, to, [self])
		if (hit):
			print("pos: " + str(hit.position))
			print("normal: " + str(hit.normal))
			add_voxel(hit.position + (hit.normal * (VOXEL_SCALE / 2)))

func plane_visibility(value):
	if has_node("plane"):
		PLANE_VISIBLE = value
		$plane.visible = value

func plane_color(value):
	if has_node("plane"):
		PLANE_COLOR = value
		$plane.get_surface_material(0).albedo_color = value

func pos_to_grid(position):
	return ((position / VOXEL_SCALE).floor() * VOXEL_SCALE) + (Vector3(VOXEL_SCALE, VOXEL_SCALE, VOXEL_SCALE) / 2)

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
	print('RAW: ' + str(position))
	voxel.translation = pos_to_grid(position)
	print('ACTUAL: ' + str(voxel.translation))
	print('---')

func remove_voxel(position, options={}):
	pass
