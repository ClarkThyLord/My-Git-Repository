tool
extends Control



# Refrences
onready var Base : TextureRect = $Base
onready var Top : TextureRect = $Base/Top



# Declarations
var angle : float = 0
var distance : float = 0
var JoystickPosition : Vector2 = Vector2()


signal activated(active)
var Active : bool = false setget set_active
func set_active(active : bool) -> void:
	Active = active
	Top.set_anchors_and_margins_preset(Control.PRESET_CENTER, Control.PRESET_MODE_KEEP_SIZE, 0)
	Base.visible = active
	if not active:
		angle = 0
		distance = 0
		JoystickPosition = Vector2()
	emit_signal('activated', active)


export(bool) var Boundless : bool = true


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
	Base.visible = Engine.editor_hint


func _input(event):
	if Active and event is InputEventMouseMotion:
		if Boundless or Base.get_rect().has_point(event.position):
			event = Base.make_input_local(event)
			angle = (Base.get_size() / 2).angle_to_point(event.position)
			var _distance = clamp((Base.get_size() / 2).distance_to(event.position), 0, Base.get_size().x / 2)
			distance = _distance / (Base.get_size().x / 2)
			var joystick_position = Vector2(-_distance * cos(angle), _distance * sin(angle))
			JoystickPosition = joystick_position / (Base.get_size().x / 2)
			
			Top.set_position(Base.get_size() / 2 + Vector2(joystick_position.x, -joystick_position.y) - Top.get_size() / 2)
		else: set_active(false)
	elif Active and event is InputEventMouseButton and not event.is_pressed(): set_active(false)


func _on_VirtualJoystick_input(event):
	if not Active and event is InputEventMouseButton and event.is_pressed():
		set_active(true)
		Base.set_position(event.position - Base.get_size() / 2)

func _on_Base_mouse_exited():
	if not Boundless: set_active(false)