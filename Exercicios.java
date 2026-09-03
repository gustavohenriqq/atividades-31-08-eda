import java.util.Scanner;

// Lista de exercicios - tudo em um arquivo so, com menu.
// Validacao de entrada:
//   - lerInteiro()          -> aceita qualquer inteiro, mas rejeita letras/simbolos
//   - lerInteiroMinimo(min) -> alem disso, exige um valor >= min (barra negativos)
public class Exercicios {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println("\n===== MENU DE EXERCICIOS =====");
            System.out.println("1 - Atividade 1: Imprimir de 1 ate N");
            System.out.println("2 - Atividade 2: Somar de 1 ate N");
            System.out.println("3 - Atividade 3: Maior e menor de 20 numeros");
            System.out.println("4 - Atividade 4: Urna eletronica");
            System.out.println("5 - Atividade 5: Exponenciacao");
            System.out.println("6 - Atividade 6: Verificar numero primo");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opcao: ");
            opcao = lerInteiro();

            switch (opcao) {
                case 1: imprimeNumeros(); break;
                case 2: somaNumeros(); break;
                case 3: maiorMenor(); break;
                case 4: urnaEletronica(); break;
                case 5: exponenciacao(); break;
                case 6: numeroPrimo(); break;
                case 0: System.out.println("Encerrando..."); break;
                default: System.out.println("Opcao invalida!");
            }
        } while (opcao != 0);

        sc.close();
    }

    // Le um inteiro; se digitarem letra/simbolo, avisa e pede de novo.
    static int lerInteiro() {
        while (!sc.hasNextInt()) {
            System.out.print("Entrada invalida! Digite um numero inteiro: ");
            sc.next(); // descarta o texto invalido digitado
        }
        return sc.nextInt();
    }

    // Le um inteiro que precisa ser >= min (usado para barrar negativos).
    static int lerInteiroMinimo(int min) {
        int valor = lerInteiro();
        while (valor < min) {
            System.out.print("Valor invalido! Digite um numero maior ou igual a " + min + ": ");
            valor = lerInteiro();
        }
        return valor;
    }

    // Atividade 1) Imprime todos os inteiros de 1 ate N (N precisa ser >= 1)
    static void imprimeNumeros() {
        System.out.print("Digite N: ");
        int n = lerInteiroMinimo(1);
        for (int i = 1; i <= n; i++) {
            System.out.println(i);
        }
    }

    // Atividade 2) Soma todos os inteiros de 1 ate N (N precisa ser >= 1)
    static void somaNumeros() {
        System.out.print("Digite N: ");
        int n = lerInteiroMinimo(1);
        int soma = 0;
        for (int i = 1; i <= n; i++) {
            soma = soma + i;
        }
        System.out.println("A soma de 1 ate " + n + " e: " + soma);
    }

    // Atividade 3) Le 20 numeros e mostra o maior e o menor
    // (aqui negativos SAO permitidos: podem ser dados validos)
    static void maiorMenor() {
        System.out.print("Digite o numero 1: ");
        int numero = lerInteiro();
        int maior = numero;
        int menor = numero;
        for (int i = 2; i <= 20; i++) {
            System.out.print("Digite o numero " + i + ": ");
            numero = lerInteiro();
            if (numero > maior) maior = numero;
            if (numero < menor) menor = numero;
        }
        System.out.println("Maior valor: " + maior);
        System.out.println("Menor valor: " + menor);
    }

    // Atividade 4) Urna eletronica com 4 candidatos, nulo, branco e encerrar
    static void urnaEletronica() {
        String[] candidatos = {"Ana", "Bruno", "Carla", "Diego"};
        int[] votos = new int[4];
        int nulos = 0, brancos = 0, voto;

        do {
            System.out.println("\n=== URNA ELETRONICA ===");
            System.out.println("1 - " + candidatos[0]);
            System.out.println("2 - " + candidatos[1]);
            System.out.println("3 - " + candidatos[2]);
            System.out.println("4 - " + candidatos[3]);
            System.out.println("5 - Voto NULO");
            System.out.println("6 - Voto em BRANCO");
            System.out.println("0 - Encerrar votacao");
            System.out.print("Seu voto: ");
            voto = lerInteiro();

            if (voto >= 1 && voto <= 4) votos[voto - 1]++;
            else if (voto == 5) nulos++;
            else if (voto == 6) brancos++;
            else if (voto == 0) System.out.println("Votacao encerrada.");
            else System.out.println("Opcao invalida!");
        } while (voto != 0);

        System.out.println("\n=== RESULTADO ===");
        int maior = -1, vencedor = 0;
        for (int i = 0; i < 4; i++) {
            System.out.println(candidatos[i] + ": " + votos[i] + " voto(s)");
            if (votos[i] > maior) {
                maior = votos[i];
                vencedor = i;
            }
        }
        System.out.println("Votos nulos: " + nulos);
        System.out.println("Votos em branco: " + brancos);
        System.out.println("Vencedor: " + candidatos[vencedor] + " com " + maior + " voto(s)");
    }

    // Atividade 5) base elevado a expoente sem usar exponenciacao
    // (base pode ser negativa; expoente precisa ser >= 0)
    static void exponenciacao() {
        System.out.print("Digite a base: ");
        int base = lerInteiro();
        System.out.print("Digite o expoente (0 ou maior): ");
        int expoente = lerInteiroMinimo(0);
        long resultado = 1;
        for (int i = 1; i <= expoente; i++) {
            resultado = resultado * base;
        }
        System.out.println(base + " ^ " + expoente + " = " + resultado);
    }

    // Atividade 6) Verifica se um numero e primo (aceita qualquer inteiro)
    static void numeroPrimo() {
        System.out.print("Digite um numero: ");
        int n = lerInteiro();
        boolean primo = true;
        if (n <= 1) {
            primo = false;
        } else {
            for (int i = 2; i < n; i++) {
                if (n % i == 0) {
                    primo = false;
                    break;
                }
            }
        }
        if (primo) System.out.println(n + " e PRIMO.");
        else System.out.println(n + " NAO e primo.");
    }
}
