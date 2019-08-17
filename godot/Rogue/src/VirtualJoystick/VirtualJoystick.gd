tool
extends Control



# Refrences
onready var Base : TextureRect = $Base
onready var Top : TextureRect = $Base/Top



# Declarations
var Angle : float = 0
var Distance : float = 0
var JoystickPosition : Vector2 = Vector2()

var touch_index


export(bool) var Constant : bool = false setget set_constant
func set_constant(constant : bool) -> void:
	Constant = constant
	if not Active and Base:
		if ReturnToOrigin: to_origin()
		Base.visible = true

export(bool) var Boundless : bool = true


enum OriginPositions {
	TopLeft = Control.PRESET_TOP_LEFT,       TopCenter = Control.PRESET_CENTER_TOP,       TopRight = Control.PRESET_TOP_RIGHT, 
	LeftCenter = Control.PRESET_CENTER_LEFT, Center = Control.PRESET_CENTER,              RightCenter = Control.PRESET_CENTER_RIGHT, 
	BottomLeft = Control.PRESET_BOTTOM_LEFT, BottomCenter = Control.PRESET_CENTER_BOTTOM, BottomRight = Control.PRESET_BOTTOM_RIGHT
}
export(OriginPositions) var OriginPosition = OriginPositions.Center setget set_origin_position
func set_origin_position(origin_position) -> void:
	OriginPosition = origin_position
	if not Active: to_origin()

export(bool) var ReturnToOrigin : bool = true


signal activated(active)
var Active : bool = false setget set_active
func set_active(active : bool) -> void:
	Active = active
	Top.set_anchors_and_margins_preset(Control.PRESET_CENTER, Control.PRESET_MODE_KEEP_SIZE, 0)
	Base.visible = active or Constant
	if not active:
		Angle = 0
		Distance = 0
		JoystickPosition = Vector2()
		touch_index = null
		if ReturnToOrigin: to_origin()
	emit_signal('activated', active)


export(int) var BaseSize : int = 160 setget set_base_size
func set_base_size(size : int) -> void:
	BaseSize = size
	if Base:
		Base.rect_size = Vector2(size, size)
		if ReturnToOrigin: to_origin()
export(Texture) var BaseTexture : Texture setget set_base_texture
func set_base_texture(texture : Texture) -> void:
	BaseTexture = texture
	if Base: Base.texture = texture

export(int) var TopSize : int = 100 setget set_top_size
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
	
	set_constant(Constant)
	set_origin_position(OriginPosition)
	
	Base.visible = Engine.editor_hint or Constant


func _input(event):
	if Active and ((event is InputEventScreenDrag and event.index == touch_index) or (touch_index == null and event is InputEventMouseMotion)):
		if Boundless or get_rect().has_point(event.position):
			event = Base.make_input_local(event)
			Angle = (Base.get_size() / 2).angle_to_point(event.position)
			var _distance = clamp((Base.get_size() / 2).distance_to(event.position), 0, Base.get_size().x / 2)
			Distance = _distance / (Base.get_size().x / 2)
			var joystick_position = Vector2(-_distance * cos(Angle), _distance * sin(Angle))
			JoystickPosition = joystick_position / (Base.get_size().x / 2)
			
			Top.set_position(Base.get_size() / 2 + Vector2(joystick_position.x, -joystick_position.y) - Top.get_size() / 2)
			get_tree().set_input_as_handled()
		else: set_active(false)
	elif Active and ((event is InputEventScreenTouch and event.index == touch_index and not event.pressed) or (touch_index == null and event is InputEventMouseButton and event.button_index == BUTTON_LEFT and not event.pressed)): set_active(false)


func _on_VirtualJoystick_input(event):
	if not Active:
		if event is InputEventScreenTouch and touch_index == null and event.is_pressed():
			touch_index = event.index
			Base.set_position(event.position - Base.get_size() / 2)
			set_active(true)
		elif event is InputEventMouseButton and event.button_index == BUTTON_LEFT and event.is_pressed():
			Base.set_position(event.position - Base.get_size() / 2)
			set_active(true)

func _on_VirtualJoystick_mouse_exited() -> void: if not Boundless: set_active(false)


func to_origin() -> void: if Base: Base.set_anchors_and_margins_preset(OriginPosition, Control.PRESET_MODE_KEEP_SIZE, 0)
