tool
extends KinematicBody2D
class_name Entity



# Declarations
signal owned(player)
signal unowned

signal selected(player)
signal unselected


var Owner : Player
var hovered := false
var Selector : Player


# Core
func _ready() -> void:
	add_to_group('entities')
	connect('mouse_entered', self, '_on_mouse_entered')
	connect('mouse_exited', self, '_on_mouse_exited')

func _process(delta): 
	if hovered or Selector: scale = Vector2(1.25, 1.25)
	else: scale = Vector2(1, 1)


func _on_mouse_entered(): hovered = true
func _on_mouse_exited(): hovered = false

func owned(owner : Player) -> void:
	Owner = owner
	emit_signal('owned', owner)

func unowned() -> void:
	Owner = null
	emit_signal('unowned')

func selected(player : Player) -> void:
	Selector = player
	if not Owner: owned(player)
	emit_signal('selected', player)

func unselected() -> void:
	Selector = null
	emit_signal('unselected')