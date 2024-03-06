package com.example.hello.worker;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

@ViewScoped
@Named("asyncBean")
public class AsyncBean implements Serializable {

        @EJB
        private AsyncService asyncService;

        private String result;

        public void countOldRecordsAsync() {
                asyncService.performAsync();
                this.setResult(asyncService.getResult());
        }

        public String getResult() {
                return result;
        }

        public void setResult(String result) {
                this.result = result;
        }
}
