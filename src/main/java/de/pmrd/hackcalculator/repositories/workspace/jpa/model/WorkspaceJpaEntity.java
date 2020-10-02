package de.pmrd.hackcalculator.repositories.workspace.jpa.model;

import javax.persistence.*;
import java.util.UUID;

@NamedQueries(
    @NamedQuery(
        name = WorkspaceJpaEntity.FIND_BY_NAME,
        query = "SELECT w FROM WorkspaceJpaEntity w WHERE w.workspace = :name"))
@Entity
@Table(name = WorkspaceJpaEntity.TABLE_NAME)
public class WorkspaceJpaEntity {

  public static final String TABLE_NAME = "HCK_WORKSPACES";
  public static final String FIND_BY_NAME = "Workspace.findByName";

  @Id private UUID id;

  @Column(unique = true)
  private String workspace;

  public WorkspaceJpaEntity() {}

  public WorkspaceJpaEntity(UUID id, String workspace) {
    this.id = id;
    this.workspace = workspace;
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getWorkspace() {
    return workspace;
  }

  public void setWorkspace(String workspace) {
    this.workspace = workspace;
  }
}
