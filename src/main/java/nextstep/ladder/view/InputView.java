package nextstep.ladder.view;

import nextstep.ladder.domain.Height;
import nextstep.ladder.domain.Name;
import nextstep.ladder.domain.Names;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String COMMA = ",";

    private InputView() {}

    public static Names inputNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String inputNames = SCANNER.nextLine();
        return splitNames(inputNames);
    }

    public static Height inputHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");

        return new Height(SCANNER.nextInt());
    }

    private static Names splitNames(String inputNames) {
        List<Name> names = Arrays.stream(inputNames.split(COMMA))
                .map(Name::new)
                .collect(Collectors.toList());
        return new Names(names);
    }
}
