tool
extends EditorPlugin

var ToolBarMenu = preload("res://addons/GoVoxly/gui/ToolBarMenu.tscn").instance()

func _enter_tree():
	# GUI
	add_control_to_container(CONTAINER_SPATIAL_EDITOR_MENU, ToolBarMenu)
	ToolBarMenu.visible = true
	
	# OBJECTS
	add_custom_type("VoxelObject", "Spatial", preload("res://addons/GoVoxly/core/VoxelObject.gd"), preload("res://addons/GoVoxly/GoVoxly.png"))
	
	print('Hello world, it\'s me Voxly!')

func _exit_tree():
	# GUI
	remove_control_from_container(CONTAINER_SPATIAL_EDITOR_MENU, ToolBarMenu)
	ToolBarMenu.free()
	
	# OBJECTS
	remove_custom_type("VoxelObject")
	
	print('Voxly is leaving now!')

#var current_object
#
#func edit(object):
#	print('here')
#	print(object)
#	current_object = object
#
#func handles(object):
#	print('also here')
#	print(object)
#	return object is Spatial
#
#func forward_input_event(event):
#	print(event)
#	var captured_event = false
#	if event.type == InputEvent.MOUSE_BUTTON:
#		if event.button_index == BUTTON_LEFT and event.is_pressed():
##			current_object = get_selection().get_selected_nodes()[0]
##			current_object.translate(Vector2(10, 10))
#			captured_event = true
#	return captured_event