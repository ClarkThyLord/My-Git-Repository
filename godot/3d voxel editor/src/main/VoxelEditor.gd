extends GridMap

export (int) var raycast_length = 100

# NOTE might have to make use of objects instead of meshes to allow usage of "custom" voxels

func _process(delta):
	if Input.is_action_just_pressed("left_m"):
		var from = get_viewport().get_camera().project_ray_origin(get_viewport().get_mouse_position())
		var to = from + get_viewport().get_camera().project_ray_normal(get_viewport().get_mouse_position()) * raycast_length
		
		var result = get_world().get_direct_space_state().intersect_ray(from, to, [get_viewport().get_camera()])
		
		if result.has('position'):
			var position = world_to_map(result.position)
			
			if Input.is_action_pressed("ctrl_k"):
				pass
				# TODO remove "selected" cell on this event
				# set_cell_item(position.x, position.y, position.z, -1)
			else:
				set_cell_item(position.x, position.y, position.z, 0)

func grid_to_mesh():
	pass
	# TODO convert GridMap to a Mesh

func mesh_to_grid():
	pass
	# TODO convert Mesh to GridMap
