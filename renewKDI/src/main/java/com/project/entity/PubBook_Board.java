package com.project.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name="pubbook_board")
public class PubBook_Board extends BaseTimeEntity {
   
   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE)
   private Long id;
   private String title;
   private String content;
   private Long readcnt;
   private String registerId;
   private Long fileid;
   private String filename;
   private Long imageid;
   private String imageName;
   
   @Builder
   public PubBook_Board(Long id, String title, String content, Long readcnt, Long fileid, String registerId, String filename, Long imageid, String imageName) {
      this.id = id;
      this.title = title;
      this.content = content;
      this.readcnt = readcnt;
      this.fileid = fileid;
      this.registerId = registerId;
      this.filename = filename;
      this.imageid = imageid;
      this.imageName = imageName;
   }
}