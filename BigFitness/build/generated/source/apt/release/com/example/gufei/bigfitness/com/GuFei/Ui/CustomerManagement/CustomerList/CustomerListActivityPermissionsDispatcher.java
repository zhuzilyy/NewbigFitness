// This file was generated by PermissionsDispatcher. Do not modify!
package com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.CustomerList;

import android.support.v4.app.ActivityCompat;
import java.lang.String;
import permissions.dispatcher.PermissionUtils;

final class CustomerListActivityPermissionsDispatcher {
  private static final int REQUEST_SHOWTOAST = 0;

  private static final String[] PERMISSION_SHOWTOAST = new String[] {"android.permission.CALL_PHONE"};

  private CustomerListActivityPermissionsDispatcher() {
  }

  static void showToastWithCheck(CustomerListActivity target) {
    if (PermissionUtils.hasSelfPermissions(target, PERMISSION_SHOWTOAST)) {
      target.showToast();
    } else {
      ActivityCompat.requestPermissions(target, PERMISSION_SHOWTOAST, REQUEST_SHOWTOAST);
    }
  }

  static void onRequestPermissionsResult(CustomerListActivity target, int requestCode, int[] grantResults) {
    switch (requestCode) {
      case REQUEST_SHOWTOAST:
      if (PermissionUtils.getTargetSdkVersion(target) < 23 && !PermissionUtils.hasSelfPermissions(target, PERMISSION_SHOWTOAST)) {
        target.denied();
        return;
      }
      if (PermissionUtils.verifyPermissions(grantResults)) {
        target.showToast();
      } else {
        if (!PermissionUtils.shouldShowRequestPermissionRationale(target, PERMISSION_SHOWTOAST)) {
          target.notAsk();
        } else {
          target.denied();
        }
      }
      break;
      default:
      break;
    }
  }
}
