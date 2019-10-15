tool
extends Node2D



# Declarations
signal eaten(_self)

export(int) var Wealth : int = 1
export(Color) var FoodColor : Color = Color(1, 1, 1) setget set_food_color
func set_food_color(color : Color) -> void:
	FoodColor = color
	update()



# Core
func _draw(): draw_circle(Vector2(), 2, FoodColor)

func _on_area_entered(area):
	if area.get_parent().is_in_group('slimes'):
		area.get_parent().eat(Wealth, FoodColor)
		emit_signal('eaten', self)
#		queue_free()
