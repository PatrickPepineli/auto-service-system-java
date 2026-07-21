import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    static int contadorId = 1;
    static int contadorVeiculoId = 1;
    static int contadorOS = 1;

    public static void main(String[] args) {

        ArrayList<Cliente> clientes = new ArrayList<>();
        ArrayList<Veiculo> veiculos = new ArrayList<>();
        ArrayList<OrdemServico> ordensServico = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);

        try {
            BufferedReader reader = new BufferedReader(
                    new FileReader("clientes.txt")
            );

            String linha;

            while ((linha = reader.readLine()) != null) {
                String [] dados = linha.split(";");
                Cliente cliente = new Cliente();
                cliente.id = Integer.parseInt(dados[0]);
                cliente.nome = dados[1];
                cliente.celular = dados[2];

                clientes.add(cliente);
            }
            reader.close();

            if( !clientes.isEmpty()) {
                contadorId = clientes.get(clientes.size() - 1).id + 1;
            }

        }catch (IOException e ) {
            System.out.println("Erro ao carregar  clientes.");
        }

        try {
            BufferedReader reader = new BufferedReader(
                    new FileReader("veiculos.txt")
            );

            String linha;

            while ((linha = reader.readLine()) != null) {
                String [] dados = linha.split(";");
                Veiculo veiculo = new Veiculo();
                veiculo.id = Integer.parseInt(dados[0]);
                veiculo.modelo = dados[1];
                veiculo.marca = dados[2];
                veiculo.placa = dados[3];
                veiculo.ano = Integer.parseInt(dados[4]);

                int idDono = Integer.parseInt(dados[5]);

                for( int i = 0; i < clientes.size(); i++) {
                    Cliente cliente = clientes.get(i);

                    if(cliente.id==idDono){
                        veiculo.dono = cliente;
                        break;
                    }
                }

                veiculos.add(veiculo);
            }
            reader.close();

            if(!veiculos.isEmpty()) {
                contadorVeiculoId = veiculos.get(veiculos.size() - 1).id + 1;
            }

        }catch (IOException e) {
            System.out.println("Erro ao carregar veículos.");
        }

        try {
            BufferedReader reader = new BufferedReader(
                    new FileReader ("OrdensDeServico.txt")
            );

            String linha;

            while ((linha = reader.readLine()) != null) {
                String [] dados = linha.split(";");
                OrdemServico ordemServico = new OrdemServico();
                ordemServico.id = Integer.parseInt(dados[0]);
                int idVeiculo = Integer.parseInt(dados[1]);
                for (int i=0; i < veiculos.size(); i++) {
                    Veiculo v = veiculos.get(i);
                    if(ordemServico == null) {
                        System.out.println("Veículo da O.Ss não encontrado! ");
                        continue;
                    }

                    if (v.id == idVeiculo) {
                        ordemServico.veiculo = v;
                        break;
                    }
                }
                ordemServico.servico = dados[2];
                ordemServico.status = dados[3];

                ordensServico.add(ordemServico);
            }
            reader.close();

            if(!ordensServico.isEmpty()) {
                contadorOS = ordensServico.get(ordensServico.size()-1).id + 1;
            }

        }catch (IOException e) {
            System.out.println("Erro ao carregar OrdemServico.");
        }

        while (true) {

            System.out.println("========== MENU ==========");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Listar Clientes");
            System.out.println("3 - Buscar Cliente");
            System.out.println("4 - Editar cliente");
            System.out.println("5 - Excluir Cliente");
            System.out.println();
            System.out.println("6 - Cadastrar veículo");
            System.out.println("7 - Listar veículos");
            System.out.println("8 - Editar veículo");
            System.out.println("9 - Excluir veículo");
            System.out.println();
            System.out.println("10 - Exibir menu de serviços");
            System.out.println("11 - Listar Ordens de Serviço:");
            System.out.println("12 - Sair");

            int opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1:
                    cadastrarCliente(clientes, sc);
                    break;

                case 2:
                    listarCliente(clientes);
                    break;

                case 3:
                    buscarCliente(clientes, sc);
                    break;

                case 4:
                 editarCliente(clientes, sc);
                    break;

                case 5:
                    excluirCliente(clientes, sc);
                    break;

                case 6:
                    Veiculo novoVeiculo = new Veiculo();

                    novoVeiculo.id = contadorVeiculoId;
                    contadorVeiculoId++;

                    System.out.println("Modelo: ");
                    novoVeiculo.modelo = sc.nextLine();

                    System.out.println("Marca: ");
                    novoVeiculo.marca = sc.nextLine();

                    System.out.println("Placa: ");
                    novoVeiculo.placa = sc.nextLine();

                    System.out.println("Ano: ");
                    novoVeiculo.ano = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Digite o ID do dono do veículo: ");
                    int IdDono = sc.nextInt();
                    sc.nextLine();

                    boolean donoEncontrado = false;

                    for (int i =0; i < clientes.size(); i++) {
                        Cliente c = clientes.get(i);

                        if (c.id == IdDono) {
                            novoVeiculo.dono = c;
                            donoEncontrado = true;
                        }
                    }

                    if (donoEncontrado) {
                        veiculos.add(novoVeiculo);

                        try {
                            BufferedWriter writer = new BufferedWriter(new FileWriter("veiculos.txt", true)
                            );


                            writer.write (
                                            novoVeiculo.id +  ";" +
                                            novoVeiculo.modelo + ";" +
                                            novoVeiculo.marca + ";" +
                                            novoVeiculo.placa + ";" +
                                                novoVeiculo.ano + ";" +
                                                novoVeiculo.dono.id
                            );

                            writer.newLine();

                            writer.close();
                        } catch (IOException ex) {

                            System.out.println("Erro ao salvar o veículo. ");
                        }

                        System.out.println("Veículo cadastrado! ");
                    } else {
                        System.out.println("Cliente não encontrado");
                    }
                    break;

                case 7:
                    listarVeiculos(veiculos);
                    break;

                case 8:
                    System.out.println("Digite o ID do carro que deseja editar: ");
                    int veiculoId = sc.nextInt();

                    boolean veiculoEncontrado = false;

                    for ( int i = 0; i < veiculos.size(); i++) {
                        Veiculo ve = veiculos.get(i);

                        if (ve.id == veiculoId) {
                            veiculoEncontrado = true;

                            System.out.println("Veiculo encontrado! ");
                            System.out.println("ID: " + ve.id +
                                               " | Modelo: " + ve.modelo +
                                               " | Marca: " + ve.marca +
                                               " | Placa: " + ve.placa +
                                               " | Ano: " + ve.ano
                            );

                            System.out.println("Esse é o veículo que deseja editar? " +
                                              "ID: " + ve.id +
                                              " | Modelo: " + ve.modelo +
                                              " | Marca: " + ve.marca +
                                              " | Placa: " + ve.placa +
                                              " | Ano: " + ve.ano +
                                              " | Digite s/n: "
                            );
                            sc.nextLine();
                            String resposta = sc.nextLine();

                            if (resposta.equalsIgnoreCase("s")) {

                                System.out.println("Novo modelo: ");
                                ve.modelo = sc.nextLine();

                                System.out.println("Nova marca: ");
                                ve.marca = sc.nextLine();

                                System.out.println("Nova placa: ");
                                ve.placa = sc.nextLine();

                                System.out.println("Novo ano: ");
                                ve.ano = sc.nextInt();
                                sc.nextLine();

                                System.out.println("Veículo editado com sucesso! ");
                            }
                        }
                    }

                if (!veiculoEncontrado) {

                    System.out.println("Veiculo não encontrado! ");
                }
                    break;

                case 9:
                    System.out.println("Digite o ID do veiculo que deseja excluir! ");
                    int id = sc.nextInt();

                    boolean veiculoRemovido = false;

                    for (int i = 0; i <veiculos.size(); i++) {
                        Veiculo vr = veiculos.get(i);

                      if (vr.id == id) {
                          System.out.println("ID encontrado: ");
                          System.out.println("Esse é o Veículo que deseja excluir? " +
                                  "ID: " + vr.id +
                                  " | Modelo: " + vr.modelo +
                                  " | Marca: " + vr.marca +
                                  " | Ano: " + vr.ano +
                                  " | Dono: " + vr.dono.nome +
                                  " | Digite s/n: "
                          );
                          sc.nextLine();
                          String resposta = sc.nextLine();

                          if (resposta.equalsIgnoreCase("s")) {
                              veiculos.remove(i);
                              veiculoRemovido = true;

                              System.out.println("Veículo removido com sucesso! ");

                              break;
                          }
                      }
                    }
                    if (!veiculoRemovido) {
                        System.out.println("Veículo não encontrado. ");
                    }
                    break;

                case 10:

                    OrdemServico novaOS = new OrdemServico();

                    System.out.println("DIgite o ID do veículo: ");
                    int idVeiculo = sc.nextInt();
                    sc.nextLine();

                    boolean veiculoencontrado = false;

                    for (int i = 0; i < veiculos.size(); i++) {
                       Veiculo iDv = veiculos.get(i);

                        if (iDv.id == idVeiculo) {
                            veiculoencontrado = true;
                            novaOS.veiculo = iDv;

                            System.out.println("Veículo encontrado e vinculado à OS! ");

                            break;
                        }
                    }

                    if (!veiculoencontrado) {
                        System.out.println("Veiculo não encontrado! ");
                        break;
                    }


                    System.out.println("============= SERVIÇOS =============");

                    System.out.println("1 - Retifica de Motores:");
                    System.out.println(" 2 - Retifica de Cabeçote");
                    System.out.println(" 3 - Planejamento de Cabeçote");
                    System.out.println(" 4 - Virabrequim");
                    System.out.println(" 5 - Teste de Trinca");
                    System.out.println(" 6 - Montagem Técinca");
                    System.out.println(" 7 - Motores Diesel");
                    System.out.println(" 8 - Motores Gasolina e Flex");
                    System.out.println(" 9 - Cabeçotes de Alumínio e Ferro Fundido");

                    System.out.println("Digite o ID do serviço desejado:");
                    int opcaoServico = sc.nextInt();
                    sc.nextLine();

                    switch (opcaoServico) {

                        case 1:
                            System.out.println("1 - Parcial");
                            System.out.println("2 - Completa");

                            int categoria = sc.nextInt();
                            sc.nextLine();

                            if (categoria == 1) {
                                novaOS.servico = " Retífica de Motores - Parcial";
                            } else if (categoria == 2) {
                                novaOS.servico = " Retífica de Motores - Completa";
                            }

                            break;

                        case 2:
                            System.out.println("1 - Simples");
                            System.out.println("2 - Intermediária");
                            System.out.println("3 - Pesada");

                            categoria = sc.nextInt();
                            sc.nextLine();

                            if (categoria == 1) {
                                novaOS.servico = "Retífica de Cabeçote - Simples";
                            } else if (categoria == 2) {
                                novaOS.servico = "Retífica de Cabeçote - Intermediaria";
                            } else {
                                novaOS.servico = "Retífica de Cabeçote - Completa";
                            }
                            break;

                        case 3:
                            novaOS.servico = "Planejamento de cabeçote";
                            break;

                        case 4:
                            novaOS.servico = "Virabrequim";
                            break;

                        case 5:
                            novaOS.servico = "Teste de trinca";
                            break;

                        case 6:
                            novaOS.servico = "Montagem técnica";
                            break;

                        case 7:
                            novaOS.servico = "Motores Diesel";
                            break;

                        case 8:
                            novaOS.servico = "Motores Gasolina e Flex";
                            break;

                        case 9:
                            novaOS.servico = "Cabeçotes Alumínio e flex";
                            break;

                        default:
                            System.out.println("Serviço inválido");
                            break;
                    }

                    if (novaOS.servico == null) {
                        break;
                    }

                    novaOS.id = contadorOS;
                     contadorOS++;

                        novaOS.status = "Aberta";
                ordensServico.add(novaOS);

                try {
                    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("OrdensDeServico.txt", true)
                    );

                    bufferedWriter.write (
                            novaOS.id + ";" +
                                    novaOS.veiculo.id + ";" +
                                    novaOS.servico + ";" +
                                    novaOS.status
                    );

                    bufferedWriter.newLine();

                    bufferedWriter.close();
                } catch (IOException ex) {

                    System.out.println("Erro ao abrir o ordensDeServico.txt");
                }

                System.out.println("Ordem de serviço criada com sucesso! ");

                break;


                case 11:
                   listarOrdensServico(ordensServico);
                    break;

                case 12:
                    System.out.println("Saindo do programa! ");
                    sc.close();
                    return;

                        default:
                            System.out.println("Opção inválida! ");
                    }

            }


        }

        // =========================================
        // MÉTODOS DE CLIENTES
        // =========================================

        public static void cadastrarCliente(ArrayList<Cliente> clientes, Scanner sc) {
            Cliente novoCliente = new Cliente();

            novoCliente.id = contadorId;
            contadorId++;

            System.out.println("Nome: ");
            novoCliente.nome = sc.nextLine();

            System.out.println("Celular: ");
            novoCliente.celular = sc.nextLine();

            clientes.add(novoCliente);

            try {

                BufferedWriter writer = new BufferedWriter( new FileWriter("clientes.txt", true)
                );

                writer.write (
                        novoCliente.id + ";" +
                                novoCliente.nome + ";" +
                                novoCliente.celular + ";"
                );

                writer.newLine();

                writer.close();
            } catch (IOException e) {

                System.out.println("Erro ao salvar o cliente. ");
            }

            System.out.println("Cliente cadastrado! ");
            System.out.println();
        }

        public static void listarCliente(ArrayList<Cliente> clientes) {
            if (clientes.size() == 0) {
                System.out.println("Nenhum cliente cadastrado. ");
            } else {
                for (int i = 0; i < clientes.size(); i++) {
                    Cliente c = clientes.get(i);
                    System.out.println(
                            "ID " + c.id +
                                    " | Nome: " + c.nome +
                                    " | Celular: " + c.celular
                    );
                    System.out.println("------------------------------------------");

                }

            }
        }

        public static void buscarCliente(ArrayList<Cliente> clientes, Scanner sc) {
            System.out.println("Digite o ID do cliente!");
            int id = sc.nextInt();

            boolean encontrado = false;

            for (int i = 0; i < clientes.size(); i++) {
                Cliente c = clientes.get(i);

                if (c.id == id) {
                    System.out.println("Cliente encontrado! ");
                    System.out.println(
                            " ID: " + c.id +
                                    " | Nome: " + c.nome +
                                    " | Celular: " + c.celular
                    );

                    encontrado = true;
                    break;

                }
            }
            if (!encontrado) {
                System.out.println("Cliente não encontrado.");
            }
        }

        public static void editarCliente(ArrayList<Cliente> clientes, Scanner sc) {
            System.out.println("Digite o ID que deseja editar: ");
            int idEditar = sc.nextInt();

            boolean clienteEncontrado = false;

            for (int i = 0; i < clientes.size(); i++) {
                Cliente ce = clientes.get(i);

                if(ce.id == idEditar) {
                    clienteEncontrado = true;

                    System.out.println("Cliente encontrado! ");
                    System.out.println(" ID: " + ce.id +
                            " | Nome: " + ce.nome +
                            " | Celular: " + ce.celular
                    );

                    System.out.println("Esse é o ID que deseja editar? " +
                            " ID: " + ce.id +
                            " | Nome: " + ce.nome +
                            " | Celular: " + ce.celular +
                            " | Digite s/n: "
                    );
                    sc.nextLine();
                    String resposta = sc.nextLine();

                    if (resposta.equalsIgnoreCase("s")) {

                        System.out.println("Novo nome: ");
                        ce.nome = sc.nextLine();

                        System.out.println("Novo celular:");
                        ce.celular = sc.nextLine();

                        System.out.println("Cliente editado com sucesso! ");
                    }

                }
            }
            if (!clienteEncontrado) {
                System.out.println("Cliente não encontrado. ");

            }
        }

        public static void excluirCliente(ArrayList<Cliente> clientes, Scanner sc) {
            System.out.println("Digite o ID que deseja excluir: ");
            int id = sc.nextInt();

            boolean encontrado = false;
            boolean removido = false;

            for (int i = 0; i < clientes.size(); i++) {
                Cliente c = clientes.get(i);

                if (c.id == id) {
                    System.out.println("ID encontrado: ");
                    System.out.println("Esse é o ID que deseja excluir? "  +
                            "ID: " + c.id  +
                            " | Nome: " + c.nome +
                            " | Digite s/n: "
                    );
                    sc.nextLine();
                    String resposta = sc.nextLine();

                    if (resposta.equalsIgnoreCase("s")) {
                        clientes.remove(i);
                        removido = true;

                        System.out.println("CLliente removido com sucesso! ");

                        break;
                    }
                }
            }
            if (!removido) {
                System.out.println("Cliente não encontrado. ");
            }
        }

        // =========================================
        // MÉTODOS DE VEÍCULOS
        // =========================================

        public static void listarVeiculos(ArrayList<Veiculo> veiculos) {
            if (veiculos.size() == 0) {
                System.out.println("Nenhum veículo cadastrado. ");
            } else {
                for (int i = 0; i < veiculos.size(); i++) {
                    Veiculo v = veiculos.get(i);
                    System.out.println("ID " + v.id +
                            " | Dono: " + v.dono.nome +
                            " | Modelo: " + v.modelo +
                            " | Marca: " + v.marca +
                            " | Placa: " + v.placa +
                            " | Ano: " + v.ano
                    );
                    System.out.println("---------------------------------------------------------------------------------");
                }
            }
        }

        // =========================================
        // MÉTODOS DE ORDENS DE SERVIÇO
        // =========================================

        public static void listarOrdensServico(ArrayList<OrdemServico> ordensServico) {
            if (ordensServico.size() == 0) {
                System.out.println("Nenhuma O.S.- cadastrada! ");
            } else {
                for (int i = 0; i < ordensServico.size(); i++) {
                    OrdemServico os = ordensServico.get(i);
                    System.out.println("OS: " + os.id +
                            " | Cliente: " + os.veiculo.dono.nome +
                            " | Veículo: "+ os.veiculo.modelo +
                            " | Serviço: " + os.servico +
                            " | Status: " + os.status
                    );
                }
            }
        }


    }
