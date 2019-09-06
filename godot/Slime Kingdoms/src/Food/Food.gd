tool
extends Node2D

export(int) var Wealth : int = 1
export(Color) var FoodColor : Color = Color(1, 1, 1) setget set_food_color
func set_food_color(color : Color) -> void:
	FoodColor = color
	update()

func _draw(): draw_circle(Vector2(), 2, FoodColor)

func _on_area_entered(area):
	if area.get_parent().is_in_group('slimes'):
		area.get_parent().eat(Wealth, FoodColor)
	queue_free()
