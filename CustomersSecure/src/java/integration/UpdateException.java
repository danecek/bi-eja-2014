/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package integration;

import javax.persistence.OptimisticLockException;

/**
 *
 * @author danecek
 */
public class UpdateException extends Exception {

    public UpdateException(OptimisticLockException ex) {
    }
    
}
