tool
extends Area2D
class_name Food



# Declarations
const _default_pixel_size := 2

signal eaten(this, entity)

export(bool) var DestroyOnEaten := false

export(bool) var RandomColor := true
export(Color) var FoodColor := Color(1, 1, 1) setget set_food_color
func set_food_color(food_color : Color) -> void:
	FoodColor = food_color
	update()



# Core
func _ready():
	if not Engine.editor_hint and RandomColor: FoodColor = Color(randf(), randf(), randf())
	update()

func _draw(): draw_circle(Vector2.ZERO, _default_pixel_size, FoodColor)

func eaten(entity : Entity) -> void:
	emit_signal('eaten', self, entity)
	if DestroyOnEaten: queue_free()
