tool
extends Entity
class_name Slime, 'res://assets/entities/slime/slime.icon.png'



# Refrences
const font = preload('res://assets/Font.tres')



# Declarations
const _default_pixel_size := 8


export(String) var Name := ''

export(int, 0, 1000, 1) var Health  := 10
export(int, 0, 1000, 1) var MaxHealth := 10

export(int, 0, 1000, 1) var Stamina  := 10
export(int, 0, 1000, 1) var MaxStamina := 10

export(int, 0, 1000, 1) var Speed := 25
export(float, 0.01, 10.0, 0.01) var SpeedBoost := 1.75

var Target


export(float, 0.01, 10, 0.01) var SlimeSize := 1.0 setget set_slime_size
func set_slime_size(slime_size : float) -> void:
	SlimeSize = slime_size
	$Sprite.scale = Vector2(slime_size, slime_size)
	($Body.shape as CircleShape2D).radius = slime_size * _default_pixel_size
	($Range.shape as CircleShape2D).radius = slime_size * _default_pixel_size * 2.5

export(Color) var SlimeColor := Color(1, 1, 1) setget set_slime_color
func set_slime_color(slime_color : Color) -> void:
	SlimeColor = slime_color
	self_modulate = slime_color



# Core
func _ready(): update()

func _process(delta):
	update()
	if Target:
		var target_pos := Vector2()
		match typeof(Target):
			TYPE_VECTOR2:
				target_pos = Target
		var direction = position.direction_to(target_pos)
		
		if Input.is_action_pressed('move_boost'): direction *= SpeedBoost
		
		move_and_collide(direction * Speed * delta)
		
		var distance = position.distance_to(target_pos)
		if distance < 6: Target = null
		
		# TODO Find Targets within range
#		var query = Physics2DShapeQueryParameters.new()
#		query.set_shape($Range.shape)
#		query.exclude = [self]
#		query.transform = transform
#		var targets = get_world_2d().direct_space_state.intersect_shape(query)

func _draw():
	draw_circle(Vector2.ZERO, _default_pixel_size * SlimeSize, SlimeColor)
	if hovered or Selector:
		# Health
		draw_line(Vector2(-_default_pixel_size / 2, -_default_pixel_size - 4), Vector2(_default_pixel_size / 2, -_default_pixel_size - 4), Color.darkred, 3)
		draw_line(Vector2(-_default_pixel_size / 2, -_default_pixel_size - 4), Vector2(Health / MaxHealth * _default_pixel_size - (_default_pixel_size / 2), -_default_pixel_size - 4), Color.red, 3)
		
		# Stamina
		draw_line(Vector2(-_default_pixel_size / 2, -_default_pixel_size), Vector2(_default_pixel_size / 2, -_default_pixel_size), Color.darkgreen, 3)
		draw_line(Vector2(-_default_pixel_size / 2, -_default_pixel_size), Vector2(Stamina / MaxStamina * _default_pixel_size - (_default_pixel_size / 2), -_default_pixel_size), Color.green, 3)

func owned(owner : Player) -> void:
	SlimeColor = owner.PlayerColor
	.owned(owner)

func unowned() -> void:
	SlimeColor = Color(1, 1, 1)
	.unowned()