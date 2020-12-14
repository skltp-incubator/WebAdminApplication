package se.skltp.adminapplication.modules.verify.domain;

import java.util.List;

public class VerifiedUrlList {

  private List verifiedUrls;

  public List getVerifiedUrls() {
    return verifiedUrls;
  }

  public void setVerifiedUrls(List<String> urls) {
    this.verifiedUrls = urls;
  }
}
