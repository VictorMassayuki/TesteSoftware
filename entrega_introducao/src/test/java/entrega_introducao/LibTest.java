
package entrega_introducao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.Test;
import entrega_introducao.App.Clube;
import entrega_introducao.App.Jogador;
import entrega_introducao.App.JogadorDTO;
import org.modelmapper.ModelMapper;

public class LibTest{

    @Test
    public void test() {
        
        final Clube clube = new Clube();
        clube.setNome("Santos");

        final Jogador jogador = new Jogador();
        jogador.setNome("Neymar");
        jogador.setClube(clube);

        final ModelMapper modelMapper = new ModelMapper();
        final JogadorDTO jogadorDTO = modelMapper.map(jogador, JogadorDTO.class);

        assertEquals("Neymar",jogadorDTO.getNome());
        assertEquals("Santos",jogadorDTO.getClubeNome());
    }

    @Test
    public void test1(){

        final Clube clube = new Clube();
        clube.setNome("Santos");

        final Jogador jogador = new Jogador();
        jogador.setNome("Neymar");
        jogador.setClube(clube);

        final ModelMapper modelMapper = new ModelMapper();
        final JogadorDTO jogadorDTO = modelMapper.map(jogador, JogadorDTO.class);

        assertNotEquals("Messi",jogadorDTO.getNome());
        assertNotEquals("Brasil",jogadorDTO.getClubeNome());
    }

}