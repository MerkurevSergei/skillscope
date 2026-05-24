package ru.skillscope.domain;

import java.util.Objects;
import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("interview_question")
public class InterviewQuestion {

    @Id
    @Column("id")
    private UUID id;

    @NotNull
    @Column("interview_id")
    private UUID interviewId;

    @NotBlank
    @Column("prompt")
    private String prompt;

    @Size(max = 40)
    @Column("expected_level")
    private String expectedLevel;

    @Column("sort_order")
    private int sortOrder;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getInterviewId() {
        return interviewId;
    }

    public void setInterviewId(UUID interviewId) {
        this.interviewId = interviewId;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public String getExpectedLevel() {
        return expectedLevel;
    }

    public void setExpectedLevel(String expectedLevel) {
        this.expectedLevel = expectedLevel;
    }

    public int getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(int sortOrder) {
        this.sortOrder = sortOrder;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InterviewQuestion that = (InterviewQuestion) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public final int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return "InterviewQuestion{" +
                "id=" + id +
                ", interviewId=" + interviewId +
                ", prompt='" + prompt + '\'' +
                ", expectedLevel='" + expectedLevel + '\'' +
                ", sortOrder=" + sortOrder +
                '}';
    }
}
