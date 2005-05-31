/*
 * Created on 5 f�vr. 2005
 *
 * Copyright (c) 2004, PMD for Eclipse Development Team
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 * 
 *     * Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the distribution.
 *     * The end-user documentation included with the redistribution, if
 *       any, must include the following acknowledgement:
 *       "This product includes software developed in part by support from
 *        the Defense Advanced Research Project Agency (DARPA)"
 *     * Neither the name of "PMD for Eclipse Development Team" nor the names of its
 *       contributors may be used to endorse or promote products derived from
 *       this software without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
 * TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A
 * PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER
 * OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.sourceforge.pmd.eclipse.model;

import net.sourceforge.pmd.eclipse.PMDPlugin;
import net.sourceforge.pmd.eclipse.PMDPluginConstants;

import org.eclipse.jface.preference.IPreferenceStore;

/**
 * This is the implementation class for the preferences model.
 * 
 * @author Philippe Herlin
 * @version $Revision$
 * 
 * $Log$
 * Revision 1.2  2005/05/31 20:33:02  phherlin
 * Continuing refactoring
 *
 * Revision 1.1  2005/05/07 13:32:04  phherlin
 * Continuing refactoring
 * Fix some PMD violations
 * Fix Bug 1144793
 * Fix Bug 1190624 (at least try)
 *
 *
 */
public class PreferencesModelImpl extends AbstractModel implements PreferencesModel, PMDPluginConstants {
    private final IPreferenceStore preferenceStore = PMDPlugin.getDefault().getPreferenceStore();
    private String reviewAdditionalComment;

    /**
     * @see net.sourceforge.pmd.eclipse.model.PreferencesModel#getReviewAdditionalComment()
     */
    public String getReviewAdditionalComment() {
        if (this.reviewAdditionalComment == null) {
            preferenceStore.setDefault(REVIEW_ADDITIONAL_COMMENT_PREFERENCE, REVIEW_ADDITIONAL_COMMENT_DEFAULT);
            this.reviewAdditionalComment = preferenceStore.getString(REVIEW_ADDITIONAL_COMMENT_PREFERENCE);
        }

        return reviewAdditionalComment;
    }

    /**
     * @see net.sourceforge.pmd.eclipse.model.PreferencesModel#setReviewAdditionalComment(java.lang.String)
     */
    public void setReviewAdditionalComment(final String comment) {
        this.reviewAdditionalComment = comment;
        preferenceStore.setValue(REVIEW_ADDITIONAL_COMMENT_PREFERENCE, comment);

    }

    /**
     * @see net.sourceforge.pmd.eclipse.model.PMDPluginModel#sync()
     */
    public void sync() throws ModelException {
        // Nothing todo for the moment.

    }
}
