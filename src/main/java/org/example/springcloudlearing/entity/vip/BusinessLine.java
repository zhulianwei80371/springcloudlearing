package org.example.springcloudlearing.entity.vip;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName t_business_line
 */
@Data
public class BusinessLine implements Serializable {
    /**
     * 
     */
    private String id;

    /**
     * 
     */
    private String created_by;

    /**
     * 
     */
    private Date created_date;

    /**
     * 
     */
    private Integer deleted;

    /**
     * 
     */
    private String last_modified_by;

    /**
     * 
     */
    private Date last_modified_date;

    /**
     * 
     */
    private Integer version;

    /**
     * 
     */
    private String business_line_code;

    /**
     * 
     */
    private String series;

    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        BusinessLine other = (BusinessLine) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCreated_by() == null ? other.getCreated_by() == null : this.getCreated_by().equals(other.getCreated_by()))
            && (this.getCreated_date() == null ? other.getCreated_date() == null : this.getCreated_date().equals(other.getCreated_date()))
            && (this.getDeleted() == null ? other.getDeleted() == null : this.getDeleted().equals(other.getDeleted()))
            && (this.getLast_modified_by() == null ? other.getLast_modified_by() == null : this.getLast_modified_by().equals(other.getLast_modified_by()))
            && (this.getLast_modified_date() == null ? other.getLast_modified_date() == null : this.getLast_modified_date().equals(other.getLast_modified_date()))
            && (this.getVersion() == null ? other.getVersion() == null : this.getVersion().equals(other.getVersion()))
            && (this.getBusiness_line_code() == null ? other.getBusiness_line_code() == null : this.getBusiness_line_code().equals(other.getBusiness_line_code()))
            && (this.getSeries() == null ? other.getSeries() == null : this.getSeries().equals(other.getSeries()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCreated_by() == null) ? 0 : getCreated_by().hashCode());
        result = prime * result + ((getCreated_date() == null) ? 0 : getCreated_date().hashCode());
        result = prime * result + ((getDeleted() == null) ? 0 : getDeleted().hashCode());
        result = prime * result + ((getLast_modified_by() == null) ? 0 : getLast_modified_by().hashCode());
        result = prime * result + ((getLast_modified_date() == null) ? 0 : getLast_modified_date().hashCode());
        result = prime * result + ((getVersion() == null) ? 0 : getVersion().hashCode());
        result = prime * result + ((getBusiness_line_code() == null) ? 0 : getBusiness_line_code().hashCode());
        result = prime * result + ((getSeries() == null) ? 0 : getSeries().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", created_by=").append(created_by);
        sb.append(", created_date=").append(created_date);
        sb.append(", deleted=").append(deleted);
        sb.append(", last_modified_by=").append(last_modified_by);
        sb.append(", last_modified_date=").append(last_modified_date);
        sb.append(", version=").append(version);
        sb.append(", business_line_code=").append(business_line_code);
        sb.append(", series=").append(series);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}