package racingcar.view;

import racingcar.domain.Car;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    public static void printCarStatus(List<Car> cars) {
        cars.forEach(car -> {
            StringBuilder track = new StringBuilder();
            track.append(car.getName().getName()).append(" : ");
            for(int i=1; i <= car.getPosition().getPosition(); i++) {
                track.append("-");
            }
            System.out.println(track);
        });
    }

    public static int getWinnerStatus(List<Car> cars) {
        return cars.stream()
                .max(Comparator.comparing(car -> car.getPosition().getPosition()))
                .get()
                .getPosition()
                .getPosition();
    }

    public static void printRacingWinner(List<Car> cars, int maxStatus) {
        String winnerMessage = cars.stream()
                                .filter(car -> car.getPosition().getPosition() == maxStatus)
                                .map(car -> car.getName().getName())
                                .collect(Collectors.joining(", "));
        System.out.println(winnerMessage + "(이)가 최종 우승했습니다.");
    }

    public static void resultView(List<Car> cars) {
        System.out.println("실행 결과");
        int maxStatus = getWinnerStatus(cars);
        printRacingWinner(cars, maxStatus);
    }
}
