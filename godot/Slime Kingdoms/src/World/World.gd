extends Node2D



# Refrences
const Food := preload('res://src/Food/Food.tscn')



# Declarations
var foods : Array = [] setget set_foods
func set_foods(foods : Array) -> void: pass
var foods_queue : Array = [] setget set_foods
func set_foods_queue(foods : Array) -> void: pass
export(int) var FoodWealth : int = 10
export(int) var FoodMaximum : int = 100



# Core
func _process(delta):
	if foods.size() < FoodMaximum:
		var food := Food.instance()
		
		food.position = Vector2(200 + randi() % 400, 200 + randi() % 400)
		food.Wealth = (randi() % FoodWealth) + 1
		food.FoodColor = Color(randf(), randf(), randf())
		
		food.connect('eaten', self, 'queue_food')
		
		foods.append(food)
		add_child(food)
	elif foods_queue.size() > 0:
		var food = foods[0]
		
		food.position = Vector2(200 + randi() % 400, 200 + randi() % 400)
		food.Wealth = (randi() % FoodWealth) + 1
		food.FoodColor = Color(randf(), randf(), randf())
		
		foods.append(food)
		add_child(food)

func queue_food(food) -> void:
	if foods.has(food) and not foods_queue.has(food):
		foods.erase(food)
		call_deferred('remove_child', food)
		queue_food(food)
