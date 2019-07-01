import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class TicTacToeShould {
    @Test
    public void be_Winner_Player_X_When_Has_Three_Symbols_In_First_Row_Inline() throws PlayerNotAllowedException, PositionTakenException {
        TicTacToe ticTacToe = new TicTacToe();

        ticTacToe.play("X", Position.create(0, 0));
        ticTacToe.play("O", Position.create(1, 0));
        ticTacToe.play("X", Position.create(0, 1));
        ticTacToe.play("O", Position.create(1, 1));
        ticTacToe.play("X", Position.create(0, 2));

        assertThat(ticTacToe.winner()).isEqualTo("X");
    }

    @Test
    public void be_Winner_Player_O_When_Has_Three_Symbols_In_First_Row_Inline() throws PlayerNotAllowedException, PositionTakenException {
        TicTacToe ticTacToe = new TicTacToe();

        ticTacToe.play("O", Position.create(0, 0));
        ticTacToe.play("X", Position.create(1, 0));
        ticTacToe.play("O", Position.create(0, 1));
        ticTacToe.play("X", Position.create(1, 1));
        ticTacToe.play("O", Position.create(0, 2));

        assertThat(ticTacToe.winner()).isEqualTo("O");
    }

    @Test
    public void be_Winner_Player_X_When_Has_Three_Symbols_In_Second_Row_Inline() throws PlayerNotAllowedException, PositionTakenException {
        TicTacToe ticTacToe = new TicTacToe();

        ticTacToe.play("X", Position.create(1, 0));
        ticTacToe.play("O", Position.create(0, 0));
        ticTacToe.play("X", Position.create(1, 1));
        ticTacToe.play("O", Position.create(0, 1));
        ticTacToe.play("X", Position.create(1, 2));

        assertThat(ticTacToe.winner()).isEqualTo("X");
    }

    @Test
    public void be_Winner_Player_X_When_Has_Three_Symbols_In_Third_Row_Inline() throws PlayerNotAllowedException, PositionTakenException {
        TicTacToe ticTacToe = new TicTacToe();

        ticTacToe.play("X", Position.create(2, 0));
        ticTacToe.play("O", Position.create(0, 0));
        ticTacToe.play("X", Position.create(2, 1));
        ticTacToe.play("O", Position.create(0, 1));
        ticTacToe.play("X", Position.create(2, 2));

        assertThat(ticTacToe.winner()).isEqualTo("X");
    }

    @Test
    public void be_Winner_Player_X_When_Has_Three_Symbols_In_First_Column_Inline() throws PlayerNotAllowedException, PositionTakenException {
        TicTacToe ticTacToe = new TicTacToe();

        ticTacToe.play("X", Position.create(0, 0));
        ticTacToe.play("O", Position.create(0, 1));
        ticTacToe.play("X", Position.create(1, 0));
        ticTacToe.play("O", Position.create(1, 1));
        ticTacToe.play("X", Position.create(2, 0));

        assertThat(ticTacToe.winner()).isEqualTo("X");
    }

    @Test
    public void be_Winner_Player_X_When_Has_Three_Symbols_Diagonally_Inline() throws PlayerNotAllowedException, PositionTakenException {
        TicTacToe ticTacToe = new TicTacToe();

        ticTacToe.play("X", Position.create(0, 0));
        ticTacToe.play("O", Position.create(1, 0));
        ticTacToe.play("X", Position.create(1, 1));
        ticTacToe.play("O", Position.create(2, 0));
        ticTacToe.play("X", Position.create(2, 2));

        assertThat(ticTacToe.winner()).isEqualTo("X");
    }

    @Test
    public void be_Winner_Player_X_When_Has_Three_Symbols_Inverse_Diagonally_Inline() throws PlayerNotAllowedException, PositionTakenException {
        TicTacToe ticTacToe = new TicTacToe();

        ticTacToe.play("X", Position.create(0, 2));
        ticTacToe.play("O", Position.create(1, 0));
        ticTacToe.play("X", Position.create(1, 1));
        ticTacToe.play("O", Position.create(2, 2));
        ticTacToe.play("X", Position.create(2, 0));

        assertThat(ticTacToe.winner()).isEqualTo("X");
    }

    @Test
    public void is_Not_Allowed_When_A_Player_Play_Two_Times_Followed() {
        TicTacToe ticTacToe = new TicTacToe();

        assertThatExceptionOfType(PlayerNotAllowedException.class).isThrownBy(() -> {
            ticTacToe.play("X", Position.create(0, 1));
            ticTacToe.play("X", Position.create(0, 1));
        });
    }

    @Test
    public void is_Not_Allowed_When_A_Player_Takes_Position_Was_Taken() {
        TicTacToe ticTacToe = new TicTacToe();

        assertThatExceptionOfType(PositionTakenException.class).isThrownBy(() -> {
            ticTacToe.play("X", Position.create(0, 1));
            ticTacToe.play("O", Position.create(0, 1));
        });
    }
}
