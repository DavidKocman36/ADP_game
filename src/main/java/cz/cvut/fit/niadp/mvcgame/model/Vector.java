package cz.cvut.fit.niadp.mvcgame.model;

public class Vector {
        private float dX = 0;
        private float dY = 0;


        public Vector(float pX, float pY) {
            this.dX = pX;
            this.dY = pY;
        }

        public float getX() {
            return dX;
        }

        public float getY() {
            return dY;
        }

        public void setX(float x) {
            this.dX = x;
        }
        public void setY(float y) {
            this.dY = y;
        }
}
