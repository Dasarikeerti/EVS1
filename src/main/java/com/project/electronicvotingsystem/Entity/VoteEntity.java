package com.project.electronicvotingsystem.Entity;

	import java.time.LocalDate;

	import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
	import javax.validation.constraints.NotNull;

	@Entity
	@Table(name="vote")
	public class VoteEntity {
		
		@Id
//		@SequenceGenerator(name="VOTE_SEQ_GEN", sequenceName="VOTE_SEQ_GEN", allocationSize=1)
//		@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="VOTE_SEQ_GEN")
		private int id;
		
		@NotNull(message="voterName is mandatory")
		private String voterName;
		
		@NotNull(message="partyName is mandatory")
		private String partyName;

		@NotNull(message="electionName is mandatory")
		private String electionName;
		
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getVoterName() {
			return voterName;
		}

		public void setVoterName(String voterName) {
			this.voterName = voterName;
		}

		public String getPartyName() {
			return partyName;
		}

		public void setPartyName(String partyName) {
			this.partyName = partyName;
		}

		public VoteEntity(int id, @NotNull(message = "voterName is mandatory") String voterName,
				@NotNull(message = "partyName is mandatory") String partyName) {
			super();
			this.id = id;
			this.voterName = voterName;
			this.partyName = partyName;
		}

		public VoteEntity() {
			super();
		}

		@Override
		public String toString() {
			return "VoteEntity [id=" + id + ", voterName=" + voterName + ", partyName=" + partyName + "]";
		}

		public String getElectionName() {
			return electionName;
		}

		public void setElectionName(String electionName) {
			this.electionName = electionName;
		}
		
	}



