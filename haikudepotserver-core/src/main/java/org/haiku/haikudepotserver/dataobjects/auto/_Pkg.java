package org.haiku.haikudepotserver.dataobjects.auto;

import java.util.Date;
import java.util.List;

import org.haiku.haikudepotserver.dataobjects.PermissionUserPkg;
import org.haiku.haikudepotserver.dataobjects.PkgChangelog;
import org.haiku.haikudepotserver.dataobjects.PkgIcon;
import org.haiku.haikudepotserver.dataobjects.PkgLocalization;
import org.haiku.haikudepotserver.dataobjects.PkgPkgCategory;
import org.haiku.haikudepotserver.dataobjects.PkgProminence;
import org.haiku.haikudepotserver.dataobjects.PkgScreenshot;
import org.haiku.haikudepotserver.dataobjects.PkgUserRatingAggregate;
import org.haiku.haikudepotserver.dataobjects.Publisher;
import org.haiku.haikudepotserver.dataobjects.support.AbstractDataObject;

/**
 * Class _Pkg was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _Pkg extends AbstractDataObject {

    public static final String ACTIVE_PROPERTY = "active";
    public static final String CREATE_TIMESTAMP_PROPERTY = "createTimestamp";
    public static final String MODIFY_TIMESTAMP_PROPERTY = "modifyTimestamp";
    public static final String NAME_PROPERTY = "name";
    public static final String PERMISSION_USER_PKGS_PROPERTY = "permissionUserPkgs";
    public static final String PKG_CHANGELOGS_PROPERTY = "pkgChangelogs";
    public static final String PKG_ICONS_PROPERTY = "pkgIcons";
    public static final String PKG_LOCALIZATIONS_PROPERTY = "pkgLocalizations";
    public static final String PKG_PKG_CATEGORIES_PROPERTY = "pkgPkgCategories";
    public static final String PKG_PROMINENCES_PROPERTY = "pkgProminences";
    public static final String PKG_SCREENSHOTS_PROPERTY = "pkgScreenshots";
    public static final String PKG_USER_RATING_AGGREGATES_PROPERTY = "pkgUserRatingAggregates";
    public static final String PUBLISHER_PROPERTY = "publisher";

    public static final String ID_PK_COLUMN = "id";

    public void setActive(Boolean active) {
        writeProperty(ACTIVE_PROPERTY, active);
    }
    public Boolean getActive() {
        return (Boolean)readProperty(ACTIVE_PROPERTY);
    }

    public void setCreateTimestamp(Date createTimestamp) {
        writeProperty(CREATE_TIMESTAMP_PROPERTY, createTimestamp);
    }
    public Date getCreateTimestamp() {
        return (Date)readProperty(CREATE_TIMESTAMP_PROPERTY);
    }

    public void setModifyTimestamp(Date modifyTimestamp) {
        writeProperty(MODIFY_TIMESTAMP_PROPERTY, modifyTimestamp);
    }
    public Date getModifyTimestamp() {
        return (Date)readProperty(MODIFY_TIMESTAMP_PROPERTY);
    }

    public void setName(String name) {
        writeProperty(NAME_PROPERTY, name);
    }
    public String getName() {
        return (String)readProperty(NAME_PROPERTY);
    }

    public void addToPermissionUserPkgs(PermissionUserPkg obj) {
        addToManyTarget(PERMISSION_USER_PKGS_PROPERTY, obj, true);
    }
    public void removeFromPermissionUserPkgs(PermissionUserPkg obj) {
        removeToManyTarget(PERMISSION_USER_PKGS_PROPERTY, obj, true);
    }
    @SuppressWarnings("unchecked")
    public List<PermissionUserPkg> getPermissionUserPkgs() {
        return (List<PermissionUserPkg>)readProperty(PERMISSION_USER_PKGS_PROPERTY);
    }


    public void addToPkgChangelogs(PkgChangelog obj) {
        addToManyTarget(PKG_CHANGELOGS_PROPERTY, obj, true);
    }
    public void removeFromPkgChangelogs(PkgChangelog obj) {
        removeToManyTarget(PKG_CHANGELOGS_PROPERTY, obj, true);
    }
    @SuppressWarnings("unchecked")
    public List<PkgChangelog> getPkgChangelogs() {
        return (List<PkgChangelog>)readProperty(PKG_CHANGELOGS_PROPERTY);
    }


    public void addToPkgIcons(PkgIcon obj) {
        addToManyTarget(PKG_ICONS_PROPERTY, obj, true);
    }
    public void removeFromPkgIcons(PkgIcon obj) {
        removeToManyTarget(PKG_ICONS_PROPERTY, obj, true);
    }
    @SuppressWarnings("unchecked")
    public List<PkgIcon> getPkgIcons() {
        return (List<PkgIcon>)readProperty(PKG_ICONS_PROPERTY);
    }


    public void addToPkgLocalizations(PkgLocalization obj) {
        addToManyTarget(PKG_LOCALIZATIONS_PROPERTY, obj, true);
    }
    public void removeFromPkgLocalizations(PkgLocalization obj) {
        removeToManyTarget(PKG_LOCALIZATIONS_PROPERTY, obj, true);
    }
    @SuppressWarnings("unchecked")
    public List<PkgLocalization> getPkgLocalizations() {
        return (List<PkgLocalization>)readProperty(PKG_LOCALIZATIONS_PROPERTY);
    }


    public void addToPkgPkgCategories(PkgPkgCategory obj) {
        addToManyTarget(PKG_PKG_CATEGORIES_PROPERTY, obj, true);
    }
    public void removeFromPkgPkgCategories(PkgPkgCategory obj) {
        removeToManyTarget(PKG_PKG_CATEGORIES_PROPERTY, obj, true);
    }
    @SuppressWarnings("unchecked")
    public List<PkgPkgCategory> getPkgPkgCategories() {
        return (List<PkgPkgCategory>)readProperty(PKG_PKG_CATEGORIES_PROPERTY);
    }


    public void addToPkgProminences(PkgProminence obj) {
        addToManyTarget(PKG_PROMINENCES_PROPERTY, obj, true);
    }
    public void removeFromPkgProminences(PkgProminence obj) {
        removeToManyTarget(PKG_PROMINENCES_PROPERTY, obj, true);
    }
    @SuppressWarnings("unchecked")
    public List<PkgProminence> getPkgProminences() {
        return (List<PkgProminence>)readProperty(PKG_PROMINENCES_PROPERTY);
    }


    public void addToPkgScreenshots(PkgScreenshot obj) {
        addToManyTarget(PKG_SCREENSHOTS_PROPERTY, obj, true);
    }
    public void removeFromPkgScreenshots(PkgScreenshot obj) {
        removeToManyTarget(PKG_SCREENSHOTS_PROPERTY, obj, true);
    }
    @SuppressWarnings("unchecked")
    public List<PkgScreenshot> getPkgScreenshots() {
        return (List<PkgScreenshot>)readProperty(PKG_SCREENSHOTS_PROPERTY);
    }


    public void addToPkgUserRatingAggregates(PkgUserRatingAggregate obj) {
        addToManyTarget(PKG_USER_RATING_AGGREGATES_PROPERTY, obj, true);
    }
    public void removeFromPkgUserRatingAggregates(PkgUserRatingAggregate obj) {
        removeToManyTarget(PKG_USER_RATING_AGGREGATES_PROPERTY, obj, true);
    }
    @SuppressWarnings("unchecked")
    public List<PkgUserRatingAggregate> getPkgUserRatingAggregates() {
        return (List<PkgUserRatingAggregate>)readProperty(PKG_USER_RATING_AGGREGATES_PROPERTY);
    }


    public void setPublisher(Publisher publisher) {
        setToOneTarget(PUBLISHER_PROPERTY, publisher, true);
    }

    public Publisher getPublisher() {
        return (Publisher)readProperty(PUBLISHER_PROPERTY);
    }


}