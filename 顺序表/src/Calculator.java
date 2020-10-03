public class Calculator {//四则运算

        private double num1;
        private double num2;

        public double getNum1() {
            return num1;
        }

        public void setNum1(double num1) {
            this.num1 = num1;
        }

        public double getNum2() {
            return num2;
        }

        public void setNum2(double num2) {
            this.num2 = num2;
        }

        public Calculator(double num1,double num2){
            setNum1(num1);
            setNum2(num2);
        }

        public Calculator() {
        }

        public double add() {
            return this.num2 + this.num1;
        }

        public double sub() {
            return this.num1 - this.num2;
        }

        public double multi() {
            return this.num1 * this.num2;
        }

        public double division() {
            return this.num1 / this.num2;
        }

}
