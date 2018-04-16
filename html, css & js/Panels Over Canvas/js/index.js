var stage, content, update = false;

// Setup everything
function init() {
  // Setup stage & content
  stage = new createjs.Stage("main_canvas");

  // Setup resize
  window.addEventListener("resize", resize);
  resize();

  content = new createjs.Container();
  content.x = stage.canvas.width / 2;
  content.y = stage.canvas.height / 2;
  stage.addChild(content);

  // Enable touch interactions
  createjs.Touch.enable(stage);

  // Enable mouse events
  stage.enableMouseOver(10);
  stage.mouseMoveOutside = true;

  // Create the first atom
  new CircleInstance();

  // Setup ticker
  createjs.Ticker.addEventListener("tick", tick);

  $(function() {
    $("#dialog").dialog();
  });
}


// Ticker: used to update
function tick() {
  if (update) {
    stage.update();
  }
}


// Resize: used to resize every component accordingly
function resize() {
  // Resize canvas
  var parent = document.querySelector("body");
  stage.canvas.width = window.innerWidth;
  stage.canvas.height = window.innerHeight;

  // Resize content
  content.x = stage.canvas.width / 2;
  content.y = stage.canvas.height / 2;

  update = true;
}


/**
 * Generate a random RGB color.
 * @return {Array} Returns a Array, containing three integers, representing a random RGB color.
 */
function randomRGB() {
  return [Math.floor(Math.random() * 255), Math.floor(Math.random() * 255), Math.floor(Math.random() * 255)];
}


/**
 * Given a RGB object return a RGB string.
 * @param {Object} [rgb] RGB object.
 * @return {String} Returns a string representing a RGB color.
 */
function stringRGB(rgb) {
  return "rgb(" + rgb[0] + "," + rgb[1] + "," + rgb[2] + ")";
}


// Create colorfull circles
function CircleInstance() {
  // Create canvas object
  var atom = new createjs.Shape();
  atom.graphics.beginFill(stringRGB(randomRGB())).drawCircle(0, 0, 25);

  // Mouse enter event handler
  atom.on("rollover", function(evt) {
    // console.log("mouse entered object");
    this.scale = 1.25;
    update = true;
  });

  // Mouse exit event handler
  atom.on("rollout", function(evt) {
    // console.log("mouse exited object");
    this.scale = 1;
    update = true;
  });

  // Mouse down events handler
  atom.on("mousedown", function(evt) {
    // console.log("picked up object");
    this.offset = {
      x: this.x - evt.stageX,
      y: this.y - evt.stageY
    };
  });

  // Mouse drag events handler
  atom.on("pressmove", function(evt) {
    // console.log("object moved");
    this.x = evt.stageX + this.offset.x;
    this.y = evt.stageY + this.offset.y;
    update = true;
  });

  // Mouse drag events handler
  atom.on("pressup", function(evt) {
    // console.log("dropped object");
  });

  content.addChild(atom);

  update = true;
}