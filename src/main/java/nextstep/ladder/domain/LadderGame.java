package nextstep.ladder.domain;

import nextstep.ladder.domain.strategy.GenerateLadderPoint;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGame {
    private Names names;
    private Lines lines;

    public LadderGame(Names names, GenerateLadderPoint generateLadderPoint, Height height) {
        this.names = names;
        initialize(height, generateLadderPoint);
    }

    private void initialize(Height height, GenerateLadderPoint generateLadderPoint) {
        this.lines = createLines(height, generateLadderPoint);
    }

    private Lines createLines(Height height, GenerateLadderPoint generateLadderPoint) {
        List<Line> lines = IntStream.range(0, height.getPoint())
                .mapToObj(i -> new Line(names.size(), generateLadderPoint))
                .collect(Collectors.toList());
        return new Lines(lines);
    }

    public Names getNames() {
        return names;
    }

    public Lines getLines() {
        return lines;
    }
}
