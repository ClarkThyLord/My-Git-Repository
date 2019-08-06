tool
extends Control



# Refrences
onready var Base : TextureRect = $Base
onready var Top : TextureRect = $Base/Top



# Declarations
export(int) var BaseSize : int = 100 setget set_base_size
func set_base_size(size : int) -> void:
	BaseSize = size
	if Base:
		Base.rect_size = Vector2(size, size)
		Top.set_anchors_and_margins_preset(Control.PRESET_CENTER, Control.PRESET_MODE_KEEP_SIZE, 0)
export(Texture) var BaseTexture : Texture setget set_base_texture
func set_base_texture(texture : Texture) -> void:
	BaseTexture = texture
	if Base: Base.texture = texture

export(int) var TopSize : int = 25 setget set_top_size
func set_top_size(size : int) -> void:
	TopSize = size
	if Top:
		Top.rect_size = Vector2(size, size)
		Top.set_anchors_and_margins_preset(Control.PRESET_CENTER, Control.PRESET_MODE_KEEP_SIZE, 0)
export(Texture) var TopTexture : Texture setget set_top_texture
func set_top_texture(texture : Texture) -> void:
	TopTexture = texture
	if Top: Top.texture = texture



# Core
func _ready():
	set_base_size(BaseSize)
	set_base_texture(BaseTexture)
	set_top_size(TopSize)
	set_top_texture(TopTexture)


func _on_VirtualJoystick_input(event):
	if event is InputEventMouseButton and event.pressed:
		Base.set_position(event.position - Base.get_size() / 2)