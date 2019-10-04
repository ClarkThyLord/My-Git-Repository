tool
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

export(Vector2) var LandsArea : Vector2 = Vector2(32, 22) setget set_lands_area
func set_lands_area(lands_area : Vector2) -> void:
	$Background.clear()
	$Interactive.clear()
	for child in get_children():
		if child.is_in_group('foods'):
			call_deferred('remove_child', child)
			queue_food(child)
	for i in range(lands_area.x * lands_area.y):
		var x = i % (lands_area.x as int)
		var y = floor(i / lands_area.x)
		if x == 0 or x == lands_area.x - 1 or y == 0 or y == lands_area.y - 1:
			$Interactive.set_cell(x, y, 1)
		$Background.set_cell(x, y, 0, false, false, false, Vector2(randi() % 4, 0))
	LandsArea = lands_area



# Core
func _process(delta):
	if not Engine.editor_hint:
		if foods.size() < FoodMaximum:
			var food := Food.instance()
			
			food.position = Vector2(randi() % ((LandsArea.x * 8) as int), randi() % ((LandsArea.y * 8) as int))
			food.Wealth = (randi() % FoodWealth) + 1
			food.FoodColor = Color(randf(), randf(), randf())
			
			food.connect('eaten', self, 'queue_food')
			
			foods.append(food)
			add_child(food)
		elif foods_queue.size() > 0:
			var food = foods[0]
			
			food.position = Vector2(randi() % ((LandsArea.x * 8) as int), randi() % ((LandsArea.y * 8) as int))
			food.Wealth = (randi() % FoodWealth) + 1
			food.FoodColor = Color(randf(), randf(), randf())
			
			foods.append(food)
			add_child(food)

func queue_food(food) -> void:
	if foods.has(food) and not foods_queue.has(food):
		foods.erase(food)
		call_deferred('remove_child', food)
		queue_food(food)
