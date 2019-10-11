tool
extends Node2D
class_name Map



# Refrences
const Food := preload('res://src/objects/food/Food.tscn')



# Declarations
const _default_pixel_size := 32

var foods := []
var queue_foods := []
export(bool) var SpawnFood := true
export(int) var MaximumFood := 100

export(Vector2) var MapSize := Vector2(1, 1)



# Core
func _process(delta):
	if not Engine.editor_hint:
		if foods.size() < MaximumFood:
			var food := Food.instance()
			spread_food(food)
			food.connect('eaten', self, 'queue_food')
			foods.append(food)
			add_child(food)
		elif queue_foods.size() > 0:
			var food : Food = queue_foods.pop_front()
			spread_food(food)
			add_child(food)


func spread_food(food : Food) -> void:
	food.position = Vector2(randi() % (MapSize.x * _default_pixel_size) as int, randi() % (MapSize.y * _default_pixel_size) as int)

func queue_food(food : Food, entity : Entity) -> void:
	remove_child(food)
	queue_foods.append(food)
