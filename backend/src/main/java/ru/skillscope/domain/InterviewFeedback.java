package ru.skillscope.domain;

import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.UUID;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("interview_feedback")
public class InterviewFeedback {

    @Id
    @Column("id")
    private UUID id;

    @NotNull
    @Column("interview_id")
    private UUID interviewId;

    @Column("reviewer_id")
    private UUID reviewerId;

    @Min(1)
    @Max(5)
    @Column("score")
    private Integer score;

    @Column("summary")
    private String summary;

    @ReadOnlyProperty
    @Column("created_at")
    private OffsetDateTime createdAt;

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

    public UUID getReviewerId() {
        return reviewerId;
    }

    public void setReviewerId(UUID reviewerId) {
        this.reviewerId = reviewerId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InterviewFeedback that = (InterviewFeedback) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public final int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return "InterviewFeedback{" +
                "id=" + id +
                ", interviewId=" + interviewId +
                ", reviewerId=" + reviewerId +
                ", score=" + score +
                ", summary='" + summary + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
