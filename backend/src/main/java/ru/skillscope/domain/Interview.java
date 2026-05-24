package ru.skillscope.domain;

import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("interview")
public class Interview {

    @Id
    @Column("id")
    private UUID id;

    @NotNull
    @Column("candidate_id")
    private UUID candidateId;

    @NotBlank
    @Size(max = 220)
    @Column("title")
    private String title;

    @NotBlank
    @Size(max = 40)
    @Column("status")
    private String status;

    @Column("scheduled_at")
    private OffsetDateTime scheduledAt;

    @ReadOnlyProperty
    @Column("created_at")
    private OffsetDateTime createdAt;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(UUID candidateId) {
        this.candidateId = candidateId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public OffsetDateTime getScheduledAt() {
        return scheduledAt;
    }

    public void setScheduledAt(OffsetDateTime scheduledAt) {
        this.scheduledAt = scheduledAt;
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
        Interview interview = (Interview) o;
        return id != null && Objects.equals(id, interview.id);
    }

    @Override
    public final int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return "Interview{" +
                "id=" + id +
                ", candidateId=" + candidateId +
                ", title='" + title + '\'' +
                ", status='" + status + '\'' +
                ", scheduledAt=" + scheduledAt +
                ", createdAt=" + createdAt +
                '}';
    }
}
