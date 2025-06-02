package view;

import java.util.List;
import java.util.Scanner;

import controller.AutoController;
import model.Auto;

public class AutoView {
    private static AutoController controller = new AutoController();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println("\n==== MENU - SISTEMA DE AUTOS ====");
            System.out.println("1 - Incluir Automóvel");
            System.out.println("2 - Excluir Automóvel");
            System.out.println("3 - Consultar Automóvel");
            System.out.println("4 - Alterar Automóvel");
            System.out.println("5 - Listar Automóveis por Ano");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            
            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida. Digite um número.");
                opcao = -1;
                continue;
            }

            switch (opcao) {
                case 1:
                    incluir();
                    break;
                case 2:
                    excluir();
                    break;
                case 3:
                    consultar();
                    break;
                case 4:
                    alterar();
                    break;
                case 5:
                    listarPorAno();
                    break;
                case 0:
                    System.out.println("Encerrando o sistema.");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);
    }

    private static void incluir() {
        Auto auto = lerDadosAuto(true);
        String resultado = controller.incluir(auto);
        System.out.println(resultado);
    }

    private static void excluir() {
        System.out.print("Digite a placa do automóvel a excluir: ");
        String placa = scanner.nextLine();
        Auto auto = new Auto();
        auto.setPlaca(placa);
        String resultado = controller.excluir(auto);
        System.out.println(resultado);
    }

    private static void consultar() {
        System.out.print("Digite a placa do automóvel a consultar: ");
        String placa = scanner.nextLine();
        Auto auto = new Auto();
        auto.setPlaca(placa);
        Auto encontrado = controller.consultar(auto);
        if (encontrado != null) {
            System.out.println("Automóvel encontrado:");
            System.out.println("Placa: " + encontrado.getPlaca());
            System.out.println("Modelo: " + encontrado.getModelo());
            System.out.println("Marca: " + encontrado.getMarca());
            System.out.println("Ano: " + encontrado.getAno());
        } else {
            System.out.println("Automóvel não encontrado.");
        }
    }

    private static void alterar() {
        System.out.print("Digite a placa do automóvel a alterar: ");
        String placa = scanner.nextLine();
        System.out.println("Digite os novos dados para esse automóvel:");
        Auto novoAuto = lerDadosAuto(false); 
        String resultado = controller.alterar(placa, novoAuto);
        System.out.println(resultado);
    }

    private static Auto lerDadosAuto(boolean incluirPlaca) {
        Auto auto = new Auto();

        if (incluirPlaca) {
            System.out.print("Placa: ");
            auto.setPlaca(scanner.nextLine());
        }

        System.out.print("Modelo: ");
        auto.setModelo(scanner.nextLine());

        System.out.print("Marca: ");
        auto.setMarca(scanner.nextLine());

        System.out.print("Ano: ");
        try {
            auto.setAno(Integer.parseInt(scanner.nextLine()));
        } catch (NumberFormatException e) {
            System.out.println("Ano inválido! Usando 0 por padrão.");
            auto.setAno(0);
        }

        return auto;
    }
    
    private static void listarPorAno() {
        List<Auto> lista = controller.listarPorAno();
        if (lista.isEmpty()) {
            System.out.println("Nenhum automóvel cadastrado.");
        } else {
            System.out.println("\n== Lista de Automóveis Ordenada por Ano ==");
            for (Auto auto : lista) {
                System.out.println("Placa: " + auto.getPlaca() +
                                   ", Modelo: " + auto.getModelo() +
                                   ", Marca: " + auto.getMarca() +
                                   ", Ano: " + auto.getAno());
            }
        }
    }

}
