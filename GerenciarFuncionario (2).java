import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerenciarFuncionario {
    public List<Funcionario> funcionarios = new ArrayList<>();
    public Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        GerenciarFuncionario gerenciarFuncionario = new GerenciarFuncionario();
        int opcao;

        do {
            System.out.println("########## MENU ##########");
            System.out.println("1 - Cadastrar Funcionario");
            System.out.println("2 - Consultar Funcionario");
            System.out.println("3 - Bonificar Apenas Um Funcionário");
            System.out.println("4 - Bonificar Todos os Funcionários");
            System.out.println("6 - Ativar/Desativar Funcionário");
            System.out.println("9 - Sair");
            System.out.println("##########################");
            opcao = Integer.parseInt(gerenciarFuncionario.sc.nextLine());

            switch (opcao) {
                case 1:
                    gerenciarFuncionario.execCadastrar();
                    break;
                case 2:
                    gerenciarFuncionario.execConsultar();
                    break;
                case 3:
                    gerenciarFuncionario.execBonificarUm();
                    break;
                case 4:
                    gerenciarFuncionario.execBonificar();
                case 5:
                    gerenciarFuncionario.execAtivarDesativar();
                    break;
                case 9:
                    System.out.println("Volte sempre!");
                    break;
                default:
                    System.out.println("Opção inválida, digite novamente.");
                    break;
            }
        } while (opcao != 9);
    }
    public void execConsultar() {
        int opcao;

        do {
            System.out.println("###### Consultar Funcionario ####### ");
            System.out.println("1 - Listar Todos Funcionários ");
            System.out.println("2 - Consultar um Funcionário  ");
            System.out.println("3 - Consultar Saldo ");
            System.out.println("4 - Voltar ao menu");
            System.out.print("Escolha sua opção: ");

            opcao = Integer.parseInt(sc.nextLine());

            switch (opcao) {
                case 1:
                    for (Funcionario funcionario : funcionarios) {
                        System.out.println(funcionario);
                    }
                    break;
                case 2:
                    execConsultarUm();
                    break;
                case 3:
                    execExibirSaldo();
                case 4:
                    break;
                default:
                    System.out.println("Opção inválida. Digite novamente");
                    break;
            }
        } while (opcao != 4);
    }

    public void execCadastrar() {
        System.out.println("Para cadastrar digite os dados do Funcionário");
        System.out.println("==========================================");

        System.out.println("Digite o número de registro: ");
        long registro = Long.parseLong(sc.nextLine());

        System.out.println("Digite o departamento: ");
        String departamento = sc.nextLine();

        System.out.println("Digite o nome: ");
        String nome = sc.nextLine();

        System.out.println("Digite o RG: ");
        String rg = sc.nextLine();

        System.out.println("Digite o salário: ");
        double salario = Double.parseDouble(sc.nextLine());

        Funcionario funcionario = new Funcionario(registro, departamento, nome, rg, salario, true);

        funcionarios.add(funcionario);

        System.out.println("Funcionário cadastrado com sucesso");
        System.out.println(funcionario);
    }

    public void execAtivarDesativar() {
        System.out.println("Para Ativar/Desativar um funcionário digite o registro do funcionário: ");
        System.out.println("=================================================");

        long registro = Long.parseLong(sc.nextLine());

        Funcionario funcionario = buscarFuncionario(registro);

        if (funcionario == null) {
            System.out.println("Funcionário não cadastrado no sistema.");
            return;
        }

        System.out.println("Estado do funcionário: " + (funcionario.Ativo() ? "Ativo" : "Inativo"));

        System.out.println("Deseja alterar o estado do funcionário? (S/N): ");
        String opcao = sc.nextLine();

        if (opcao.toLowerCase().equals("s")) {
            funcionario.setEstaAtivo(!funcionario.Ativo());
            System.out.println("Estado do funcionário foi alterado");
            System.out.println(funcionario);
        }
    }

    public void execExibirSaldo() {
        System.out.println("========EXIBIR SALDO========");

        System.out.println("Digite o registro do funcionário: ");
        long registro = Long.parseLong(sc.nextLine());

        Funcionario funcionario = buscarFuncionario(registro);

        if (funcionario == null) {
            System.out.println("Funcionário não consta no sistema.");
            return;
        }

        System.out.println("Saldo do funcionário: " + funcionario.getSalario());
    }

    public void execConsultarUm() {
        System.out.println("Digite o registro do funcionário: ");
        long registro = Long.parseLong(sc.nextLine());

        Funcionario funcionario = buscarFuncionario(registro);

        if (funcionario == null) {
            System.out.println("Funcionário não cadastrado no sistema.");
            return;
        }

        System.out.println(funcionario);
    }

    private Funcionario buscarFuncionario(long registro) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getRegistro() == registro) {
                return funcionario;
            }
        }
        return null;
    }

    public void execBonificarUm() {
        System.out.println("Digite o número de registro: ");
        long registro = Long.parseLong(sc.nextLine());

        System.out.println("Digite o valor da bonificação: ");
        double salario = Double.parseDouble(sc.nextLine());

        Funcionario funcionario = buscarFuncionario(registro);

        if (funcionario == null) {
            System.out.println("Funcionário não existe no sistema");
            return;
        }

        if (funcionario.Ativo()) {
            funcionario.bonificar(salario);

            System.out.println("Funcionário: " + funcionario);
            System.out.println("Foi bonificado com sucesso no valor de " + salario);
            return;
        }

        System.out.println("Funcionário inativo, não é possível realizar a bonificação");
    }

    public void execBonificar() {
        System.out.println("Digite o valor da bonificação: ");
        double salario = Double.parseDouble(sc.nextLine());

        for (Funcionario funcionario : funcionarios) {
            if (funcionario.Ativo())
                funcionario.bonificar(salario);
        }

        System.out.println("Funcionários bonificados com sucesso.");
        System.out.println("Valor da bonificação: " + salario);
    }
}