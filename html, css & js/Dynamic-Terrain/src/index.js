// DYNAMICTERRAIN
function DynamicTerrain() {
	this.seed = 0;
	this.noise_step = 0.1;
	this.noise_position = 0;
	this.noise_dynamic = false;
	this.noise = new SimplexNoise(`${this.seed}`);
	this.terrain_low = -100;
	this.terrain_high = 100;
	this.terrain_size = 50;
	this.terrain_segments = 100;
	this.terrain = new THREE.Mesh(new THREE.PlaneGeometry(this.terrain_size, this.terrain_size, this.terrain_segments, this.terrain_segments),
		new THREE.MeshBasicMaterial({
			color: 0xffaa00,
			wireframe: true
		})
	);

	this.update = function () {
		// console.log('update!');

		for (var x = 0; x < this.terrain_segments; x++) {
			for (var y = 0; y < this.terrain_segments; y++) {
				this.terrain.geometry.vertices[x + y * this.terrain_segments].z = this.noise.noise2D((x + (this.noise_dynamic ? this.noise_position : 0)) * this.noise_step, (y + (this.noise_dynamic ? this.noise_position : 0)) * this.noise_step);
				this.noise_position += 0.1;
			}
		}

		this.terrain.geometry.verticesNeedUpdate = true;
	};
}

// CORE
function update() {
	DYNAMICTERRAIN.update();

	render();
	requestAnimationFrame(update);
}

function redraw() {
	RENDERER.setSize(window.innerWidth, window.innerHeight);
	CAMERA.aspect = window.innerWidth / window.innerHeight;
	CAMERA.updateProjectionMatrix();
	render();
}

function render() {
	RENDERER.render(SCENE, CAMERA);
}

// INIT
var SCENE = new THREE.Scene();
SCENE.background = new THREE.Color(0xefd1b5);
SCENE.fog = new THREE.FogExp2(0xefd1b5, 0.075);

var CAMERA = new THREE.PerspectiveCamera(75, window.innerWidth/window.innerHeight, 0.1, 1000);
CAMERA.position.y = -10;
CAMERA.position.z = 7.5;
CAMERA.rotateX(45);

var RENDERER = new THREE.WebGLRenderer({
	antialias: true
});
RENDERER.setSize(window.innerWidth, window.innerHeight);
document.body.appendChild(RENDERER.domElement);

// SETUP
var DYNAMICTERRAIN = new DynamicTerrain();
SCENE.add(DYNAMICTERRAIN.terrain);

// EVENTS
window.addEventListener('resize', redraw, false);

// START
update();
