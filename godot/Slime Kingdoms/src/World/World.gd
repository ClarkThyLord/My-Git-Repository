extends Node2D



# Refrences
const Food := preload('res://src/Food/Food.tscn')



# Declarations
var food_count : int = 0
export(int) var FoodWealth : int = 10
export(int) var FoodMaximum : int = 100

func _process(delta):
	if food_count < FoodMaximum:
		var food := Food.instance()
		food.position = Vector2(randi() % 400, randi() % 400)
		food.Wealth = (randi() % FoodWealth) + 1
		food.FoodColor = Color(randf(), randf(), randf())
		add_child(food)
