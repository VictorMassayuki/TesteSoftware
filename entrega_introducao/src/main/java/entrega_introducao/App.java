
package entrega_introducao;

import org.modelmapper.ModelMapper;

public class App{
	
	public static class Jogador{

        public Jogador() {
		}

	    private String nome;
	    private Clube clube;
	    
		public String getNome() {
			return nome;
		}
		public void setNome(final String nome) {
            this.nome = nome;
        }

        public Clube getClube() {
            return clube;
        }

        public void setClube(final Clube clube) {
            this.clube = clube;
        }

    }

    public static class Clube {

        public Clube() {
        }
        
        private String nome;

        public String getNome() {
            return nome;
        }

        public void setNome(final String nome) {
            this.nome = nome;
        }

    }

    public static class JogadorDTO {

        public JogadorDTO() {
		}

        private String nome;
        private String clubeNome;

        public String getNome() {
            return nome;
        }

        public void setNome(final String nome) {
            this.nome = nome;
        }

        public String getClubeNome() {
            return clubeNome;
        }

        public void setClubeNome(final String clubeNome) {
            this.clubeNome = clubeNome;
        }

    }

    public static void main(final String[] args) {
        final Clube clube = new Clube();
        clube.setNome("Santos");

        final Jogador jogador = new Jogador();
        jogador.setNome("Neymar");
        jogador.setClube(clube);

        final ModelMapper modelMapper = new ModelMapper();

        final JogadorDTO jogadorDTO = modelMapper.map(jogador, JogadorDTO.class);

        System.out.println(jogadorDTO.getNome());
        System.out.println(jogadorDTO.getClubeNome());
    }

}