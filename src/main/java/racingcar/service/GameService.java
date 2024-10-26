package racingcar.service;

import racingcar.model.Car;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.view.OutputView;

public class GameService {

    private final OutputView outputView;

    public GameService() {
        this.outputView = new OutputView();
    }

    public void startGame(Car[] cars, int round) {
        for (int i = 0; i < round; i++) {
            playRound(cars);
        }
    }

    private void playRound(Car[] cars) {
        outputView.executeMessage();

        for (Car car : cars) {
            int randomNumber = getRandomNumber();

            moveForward(car, randomNumber);

            outputView.roundEndMessage(car);
        }
    }

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    private void moveForward(Car car, int randomNumber) {
        if (randomNumber >= 4) {
            car.forward();
        }
    }
}
