package no.hiof.larsmra.gameengine;

/**
 * This class is responsible for movement player controlled entities.
 */
final public class MovementControls {

    private int up = -1, down = -1, left = -1, right = -1;

    public MovementControls() {

    }

    public void bindKeyUp(int keyCode) {
        up = keyCode;
    }

    public void bindKeyDown(int keyCode) {
        down = keyCode;
    }

    public void bindKeyLeft(int keyCode) {
        left = keyCode;
    }

    public void bindKeyRight(int keyCode) {
        right = keyCode;
    }

    public int getUp() {
        return up;
    }

    public int getDown() {
        return down;
    }

    public int getLeft() {
        return left;
    }

    public int getRight() {
        return right;
    }

    public static class MovementControlsBuilder {

        private MovementControls mc;

        public MovementControlsBuilder() {
            mc = new MovementControls();
        }

        public MovementControlsBuilder bindKeyUp(int keyCode) {
            mc.up = keyCode;
            return this;
        }

        public MovementControlsBuilder bindKeyDown(int keyCode) {
            mc.down = keyCode;
            return this;
        }

        public MovementControlsBuilder bindKeyLeft(int keyCode) {
            mc.left = keyCode;
            return this;
        }

        public MovementControlsBuilder bindKeyRight(int keyCode) {
            mc.right = keyCode;
            return this;
        }

        public MovementControls build() {
            MovementControls mc = new MovementControls();

            mc.up = this.mc.up;
            mc.down = this.mc.down;
            mc.left = this.mc.left;
            mc.right = this.mc.right;

            this.mc = null;

            return mc;
        }

    }
}
