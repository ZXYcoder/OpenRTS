/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.map.cliff.faces.natural;

import collections.Ring;
import geometry.Point2D;
import geometry3D.Point3D;
import geometry3D.Polygon3D;
import java.awt.Color;
import java.util.ArrayList;
import math.Angle;
import math.MyRandom;
import model.map.Tile;
import model.map.cliff.Trinket;
import model.map.cliff.Cliff;
import model.map.cliff.faces.Face;
import tools.LogUtil;

/**
 *
 * @author Benoît
 */
public class NaturalFace extends Face {
    public NaturalFaceMesh mesh;

    Cliff cliff;
    double noiseX, noiseY, noiseZ;
    double ridgeDepthRange, ridgePosRange;
    public Color color;
    public String texturePath;
    
    ArrayList<Point3D> parentProfile = new ArrayList<>();
    ArrayList<Point3D> middleProfile = new ArrayList<>();
    ArrayList<Point3D> childProfile = new ArrayList<>();
    Point3D[][] grid;
    
    public NaturalFace(Cliff cliff, double noiseX, double noiseY, double noiseZ, double ridgeDepth, double ridgePos, Color color, String texturePath){
        this.cliff = cliff;
        this.noiseX = noiseX;
        this.noiseY = noiseY;
        this.noiseZ = noiseZ;
        this.ridgeDepthRange = ridgeDepth;
        this.ridgePosRange = ridgePos;
        this.color = color;
        this.texturePath = texturePath;
    }

    public NaturalFace(NaturalFace o){
        this.cliff = o.cliff;
        this.noiseX = o.noiseX;
        this.noiseY = o.noiseY;
        this.noiseZ = o.noiseZ;
        this.ridgeDepthRange = o.ridgeDepthRange;
        this.ridgePosRange = o.ridgePosRange;
        this.color = o.color;
        this.texturePath = o.texturePath;
    }

    @Override
    public String getType() {
        return "natural";
    }
    
    protected NaturalFace getParentFace(){
        if(cliff.parent != null &&
                cliff.parent.cliff != null &&
                cliff.parent.cliff.face instanceof NaturalFace)
            return (NaturalFace)(cliff.parent.cliff.face);
        else
            return null;
    }
    protected NaturalFace getChildFace(){
        if(cliff.child != null &&
                cliff.child.cliff != null &&
                cliff.child.cliff.face instanceof NaturalFace)
            return (NaturalFace)(cliff.child.cliff.face);
        else
            return null;
    }

    @Override
    public ArrayList<Ring<Point3D>> getGrounds() {
        throw new UnsupportedOperationException("Can't be launched form this mother class.");
    }
}
