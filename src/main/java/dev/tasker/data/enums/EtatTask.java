package dev.tasker.data.enums;
import lombok.AllArgsConstructor;
import lombok.Getter;
@AllArgsConstructor
@Getter

public enum EtatTask {
        Plannified(0),
        InProgress(1),
        Completed(1);
        private final Integer index;
}
