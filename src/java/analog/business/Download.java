/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analog.business;

import java.util.Date;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Download implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long downloadId;

    @ManyToOne(fetch=FetchType.EAGER)
    private User user;

    @Temporal(TemporalType.DATE)
    private Date downloadDate;

    private String productCode;

    public Download() {
        user = null;
        downloadDate = new Date();
        productCode = "";
    }

    public Long getDownloadId() {
        return downloadId;
    }

    public void setDownloadId(Long downloadId) {
        this.downloadId = downloadId;
    }

    public void setUser(User u) {
        user = u;
    }

    public User getUser() {
        return user;
    }

    public void setDownloadDate(Date date) {
        downloadDate = date;
    }

    public Date getDownloadDate() {
        return downloadDate;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductCode() {
        return productCode;
    }
}
