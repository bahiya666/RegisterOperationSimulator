import java.util.*;

public class Register {
    List<RegisterOperation> operations = new ArrayList<>();

    void write(int value, int startTime, int endTime) {
        operations.add(new RegisterOperation(RegisterOperation.Type.WRITE, value, startTime, endTime));
    }

    void read(int startTime, int endTime) {
        operations.add(new RegisterOperation(RegisterOperation.Type.READ, null, startTime, endTime));
    }

    List<List<Integer>> getValidReadValues() {
        List<List<Integer>> results = new ArrayList<>();
        collectValidReadCombinations(0, new ArrayList<>(), results);
        return results;
    }

    private void collectValidReadCombinations(int index, List<Integer> currentCombination, List<List<Integer>> results) {
        if (index == operations.size()) {
            results.add(new ArrayList<>(currentCombination));
            return;
        }

        RegisterOperation operation = operations.get(index);

        if (operation.type == RegisterOperation.Type.READ) {
            List<Integer> potentialValues = determinePossibleReadValues(operation);
            for (Integer value : potentialValues) {
                currentCombination.add(value);
                collectValidReadCombinations(index + 1, currentCombination, results);
                currentCombination.remove(currentCombination.size() - 1);
            }
        } else {
            collectValidReadCombinations(index + 1, currentCombination, results);
        }
    }

    private List<Integer> determinePossibleReadValues(RegisterOperation readOperation) {
        List<Integer> possibleValues = new ArrayList<>();
        Integer lastWrite = null;

        for (RegisterOperation op : operations) {
            if (op.type == RegisterOperation.Type.WRITE && op.endTime <= readOperation.startTime) {
                lastWrite = op.value;
            } else if (op.type == RegisterOperation.Type.WRITE && op.startTime <= readOperation.endTime && op.endTime > readOperation.startTime) {
                possibleValues.add(op.value);
            }
        }

        if (lastWrite != null) {
            possibleValues.add(lastWrite);
        } else {
            possibleValues.add(null);
        }

        return possibleValues;
    }
}
