package cz.cvut.fit.niadp.mvcgame.model;

public class Vector {
        private int dX = 0;
        private int dY = 0;


        public Vector(int pX, int pY) {
            this.dX = pX;
            this.dY = pY;
        }

        public int getX() {
            return dX;
        }

        public int getY() {
            return dY;
        }

        public void setX(int x) {
            this.dX = x;
        }
        public void setY(int y) {
            this.dY = y;
        }
}
