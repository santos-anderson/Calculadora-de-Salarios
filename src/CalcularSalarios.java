import java.util.Scanner;

public class CalcularSalarios {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[] salarios = new double[5];

        System.out.println("Digite os 5 salários dos funcionários, separados por espaço:");

        for (int i = 0; i < 5; i++) {
            salarios[i] = sc.nextDouble();


            double salarioBruto = salarios[i];
            double descontoINSS = calcularDescontoINSS(salarioBruto);
            double descontoIR = calcularDescontoIR(salarioBruto);
            double salarioLiquido = salarioBruto - descontoINSS - descontoIR;


            System.out.println("\nSalário do funcionário " + (i + 1) + " Detalhado:");
            System.out.printf("Salário Bruto: R$ %.2f\n", salarioBruto);
            System.out.printf("Desconto INSS: R$ %.2f\n", descontoINSS);
            System.out.printf("Desconto Imposto de Renda: R$ %.2f\n", descontoIR);
            System.out.printf("Salário Líquido: R$ %.2f\n", salarioLiquido);
        }

    }

    public static double calcularDescontoINSS(double salario) {
        double descontoINSS = 0;

        if (salario <= 1212.00) {
            descontoINSS = salario * 0.075;
        } else if (salario <= 2427.35) {
            descontoINSS = salario * 0.09;
        } else if (salario <= 3641.03) {
            descontoINSS = salario * 0.12;
        } else if (salario <= 7087.22) {
            descontoINSS = salario * 0.14;
        }

        return descontoINSS;
    }

    public static double calcularDescontoIR(double salario) {
        double descontoIR = 0;

        if (salario <= 1903.98) {
            descontoIR = 0;  // 0%
        } else if (salario <= 2826.65) {
            descontoIR = salario * 0.075;
        } else if (salario <= 3751.05) {
            descontoIR = salario * 0.15;
        } else if (salario <= 4664.68) {
            descontoIR = salario * 0.225;
        } else {
            descontoIR = salario * 0.275;
        }

        return descontoIR;
    }
}

