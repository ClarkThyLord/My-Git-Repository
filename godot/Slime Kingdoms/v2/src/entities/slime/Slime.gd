tool
extends KinematicBody2D
class_name Slime, 'res://assets/entities/slime/king/king.png'



# Refrences
const font = preload('res://assets/Font.tres')



# Declarations
const _default_pixel_size := 8


var hovered := false
var selected := false
var selector = null


export(String) var Name := ''


export(int, 0, 1000, 1) var Health  := 10
export(int, 0, 1000, 1) var MaxHealth := 10

export(int, 0, 1000, 1) var Stamina  := 10
export(int, 0, 1000, 1) var MaxStamina := 10


export(float, 0.01, 10, 0.01) var SlimeSize := 1.0 setget set_slime_size
func set_slime_size(slime_size : float) -> void:
	SlimeSize = slime_size
	$Sprite.scale = Vector2(slime_size, slime_size)
	($Body.shape as CircleShape2D).radius = slime_size * _default_pixel_size

export(Color) var SlimeColor := Color(1, 1, 1) setget set_slime_color
func set_slime_color(slime_color : Color) -> void:
	SlimeColor = slime_color
	self_modulate = slime_color



# Core
func _ready(): update()

func _process(delta):
	update()
	if hovered or selected: scale = Vector2(1.25, 1.25)
	else: scale = Vector2(1, 1)


func _on_mouse_entered(): hovered = true
func _on_mouse_exited(): hovered = false


func _draw():
	draw_circle(Vector2.ZERO, _default_pixel_size * SlimeSize, SlimeColor)
	if hovered or selected:
		# Health
		draw_line(Vector2(-_default_pixel_size / 2, -_default_pixel_size - 4), Vector2(_default_pixel_size / 2, -_default_pixel_size - 4), Color.darkred, 3)
		draw_line(Vector2(-_default_pixel_size / 2, -_default_pixel_size - 4), Vector2(Health / MaxHealth * _default_pixel_size - (_default_pixel_size / 2), -_default_pixel_size - 4), Color.red, 3)
		
		# Stamina
		draw_line(Vector2(-_default_pixel_size / 2, -_default_pixel_size), Vector2(_default_pixel_size / 2, -_default_pixel_size), Color.darkgreen, 3)
		draw_line(Vector2(-_default_pixel_size / 2, -_default_pixel_size), Vector2(Stamina / MaxStamina * _default_pixel_size - (_default_pixel_size / 2), -_default_pixel_size), Color.green, 3)
