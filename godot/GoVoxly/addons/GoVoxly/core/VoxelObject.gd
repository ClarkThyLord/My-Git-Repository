tool
extends Spatial

#var VoxelObject = preload("res://addons/GoVoxly/core/VoxelObject/VoxelObject.tscn").instance()
#const Voxel = preload("res://addons/GoVoxly/CORE/VoxelObject/Voxel.tscn")

var PLANE = MeshInstance.new()

export(bool) var PLANE_VISIBLE = true setget plane_visibility

func _enter_tree():
	PLANE.visible = true
	PLANE.mesh = PlaneMesh.new()
	PLANE.scale = Vector3(10, 1, 10)
	add_child(PLANE)
#	add_child(VoxelObject)

func _exit_tree():
	remove_child(PLANE)
	PLANE.free()
#	remove_child(VoxelObject)
#	VoxelObject.free()

func _ready():
	pass

func plane_visibility(value):
	PLANE_VISIBLE = value
#	VoxelObject.visible = true
