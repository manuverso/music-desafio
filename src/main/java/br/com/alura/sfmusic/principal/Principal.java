package br.com.alura.sfmusic.principal;

import br.com.alura.sfmusic.models.Artista;
import br.com.alura.sfmusic.models.Musica;
import br.com.alura.sfmusic.models.TipoArtista;
import br.com.alura.sfmusic.repository.ArtistaRepository;
import br.com.alura.sfmusic.services.ConsultaGemini;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Principal {
    private Scanner leitura = new Scanner(System.in);


    private ArtistaRepository repositorio;


    public Principal(ArtistaRepository repositorio) {
        this.repositorio = repositorio;
    }


    public void exibirMenu () {
        var opcao = -1;


        while (opcao != 0) {
            var menu = """
                        1- Cadastrar artista
                        2- Cadastrar música
                        3- Listar músicas
                        4- Buscar músicas por artistas
                        5- Pesquisar sobre um artista
                        0- Sair
                        """;

            System.out.println(menu);
            opcao = leitura.nextInt();
            leitura.nextLine();

            switch (opcao) {
                case 1:
                    buscarArtista();
                    break;
                case 2:
                    buscarMusica();
                    break;
                case 3:
                    listarMusicas();
                    break;
                case 4:
                    buscarMusicaPorArtista();
                    break;
                case 5:
                    pesquisarDadosArtista();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }

    }



    private void pesquisarDadosArtista() {
        System.out.println("Qual artista você deseja pesquisar? ");
        var nome = leitura.nextLine();
        var resposta = ConsultaGemini.obterInformacao(nome);
        System.out.println(resposta.trim());
    }



    private void buscarMusicaPorArtista() {
        System.out.println("Buscar músicas de qual artista? ");
        var nome = leitura.nextLine();
        List<Musica> musicas = repositorio.buscarMusicasPorArtista(nome);
        musicas.forEach(System.out::println);

    }



    private void listarMusicas() {
        List<Artista> artistas = repositorio.findAll();
        artistas.forEach(a -> a.getMusicas().forEach(System.out::println));
    }



    private void buscarMusica() {
        System.out.println("A música é de qual artista? ");
        var nome = leitura.nextLine();
        Optional<Artista> artista = repositorio.findByNomeContainingIgnoreCase(nome);

        if (artista.isPresent()){
            System.out.println("Qual o titulo/nome da música?");
            var titulo = leitura.nextLine();
            Musica musica = new Musica(titulo);
            musica.setArtista(artista.get());
            artista.get().getMusicas().add(musica);
            repositorio.save(artista.get());

        } else {
            System.out.println("Artista não encontrado");
        }
    }



    private void buscarArtista() {
        var cadastrarNovo = "S";

        while (cadastrarNovo.equalsIgnoreCase("S")) {
            System.out.println("Qual o nome desse artista? ");
            var nome = leitura.nextLine();
            System.out.println("Qual o tipo dele? (solo/banda/dupla)");
            var tipo = leitura.nextLine();
            TipoArtista tipoArtista = TipoArtista.valueOf(tipo.toUpperCase());
            Artista artista = new Artista(nome, tipoArtista);
            repositorio.save(artista);
            System.out.println("Cadastrar um novo artista? (S/N)");
            cadastrarNovo = leitura.nextLine();
            leitura.nextLine();
        }
    }
}
